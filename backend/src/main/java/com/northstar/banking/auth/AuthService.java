package com.northstar.banking.auth;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
@Service
public class AuthService {
 private static final int MAX_ATTEMPTS=5; private static final Duration LOCK_DURATION=Duration.ofMinutes(15);
 private final java.util.Map<String,ResetChallenge> resets=new java.util.concurrent.ConcurrentHashMap<>();
 private record ResetChallenge(String code,Instant expiresAt) {}
 private final DigitalUserRepository users; private final PasswordEncoder encoder; private final JwtService jwt; private final PasswordResetEmailService resetEmail;
 public AuthService(DigitalUserRepository users,PasswordEncoder encoder,JwtService jwt,PasswordResetEmailService resetEmail){this.users=users;this.encoder=encoder;this.jwt=jwt;this.resetEmail=resetEmail;}
 @Transactional(noRollbackFor = AuthFailure.class) public AuthModels.LoginResponse login(String userId,String password){
  if(userId==null||userId.isBlank()||password==null||password.isEmpty()) throw new AuthFailure("User ID and password are required.");
  DigitalUser user=users.findForLogin(userId.trim()).orElse(null);
  if(user==null){encoder.matches(password,"$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy");throw new AuthFailure("Invalid user ID or password.");}
  Instant now=Instant.now();
  if(!user.isActiveFlag())throw new AuthFailure("This account is inactive. Contact support.");
  if(user.isLockFlag()) { if(user.getLockedUntil()!=null&&now.isBefore(user.getLockedUntil()))throw new AuthFailure("Account is temporarily locked. Try again after 15 minutes."); user.unlockExpired(); }
  if(!encoder.matches(password,user.getPasswordHash())){user.recordFailure(MAX_ATTEMPTS,now.plus(LOCK_DURATION));throw new AuthFailure(user.isLockFlag()?"Too many failed attempts. Account locked for 15 minutes.":"Invalid user ID or password.");}
  user.recordSuccess(now); return jwt.issue(user);
 }

 @Transactional public String requestPasswordReset(String userId,String emailId){
  if(userId==null||emailId==null)throw new AuthFailure("User ID and registered email are required.");
  DigitalUser user=users.findByUserIdIgnoreCase(userId.trim()).orElseThrow(()->new AuthFailure("No matching account was found."));
  if(!user.isActiveFlag()||!user.getEmailId().equalsIgnoreCase(emailId.trim()))throw new AuthFailure("No matching account was found.");
  String code=String.format("%06d",new java.security.SecureRandom().nextInt(1_000_000));String key=user.getUserId().toLowerCase();resets.put(key,new ResetChallenge(code,Instant.now().plus(Duration.ofMinutes(10))));try{resetEmail.sendResetCode(user.getEmailId(),user.getName(),code);}catch(PasswordResetEmailService.MailDeliveryFailure failure){resets.remove(key);throw failure;}return "If the account details match, a reset code has been sent to the registered email address.";
 }
 @Transactional(noRollbackFor=AuthFailure.class) public void completePasswordReset(String userId,String code,String newPassword){
  if(userId==null||code==null||newPassword==null||newPassword.length()<10)throw new AuthFailure("Enter the reset code and a password of at least 10 characters.");
  String key=userId.trim().toLowerCase();ResetChallenge challenge=resets.get(key);
  if(challenge==null||Instant.now().isAfter(challenge.expiresAt())||!java.security.MessageDigest.isEqual(challenge.code().getBytes(java.nio.charset.StandardCharsets.UTF_8),code.getBytes(java.nio.charset.StandardCharsets.UTF_8)))throw new AuthFailure("Reset code is invalid or expired.");
  DigitalUser user=users.findByUserIdIgnoreCase(userId.trim()).orElseThrow(()->new AuthFailure("No matching account was found."));user.changePassword(encoder.encode(newPassword));resets.remove(key);
 }
 @Transactional public AuthModels.UserDetails updateProfile(String userId,String name,String mobileNo,String emailId){
  DigitalUser user=users.findByUserIdIgnoreCase(userId).orElseThrow(()->new AuthFailure("User was not found."));
  if(name==null||name.isBlank()||mobileNo==null||mobileNo.isBlank()||emailId==null||emailId.isBlank()||!emailId.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))throw new AuthFailure("Enter a name, mobile number, and valid email address.");
  user.updateProfile(name.trim(),mobileNo.trim(),emailId.trim());return user.toUserDetails();
 }
 public static class AuthFailure extends RuntimeException { public AuthFailure(String message){super(message);} }
}
