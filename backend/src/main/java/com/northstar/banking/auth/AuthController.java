package com.northstar.banking.auth;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth")
public class AuthController {
 private final AuthService auth; private final DigitalUserRepository users;
 public AuthController(AuthService auth,DigitalUserRepository users){this.auth=auth;this.users=users;}
 @PostMapping("/login") public AuthModels.LoginResponse login(@RequestBody AuthModels.LoginRequest request){return auth.login(request.userId(),request.password());}
 @PostMapping("/password-reset/request") public AuthModels.ResetRequestResponse requestReset(@RequestBody AuthModels.ResetRequest request){String message=auth.requestPasswordReset(request.userId(),request.emailId());return new AuthModels.ResetRequestResponse(message);}
 @PostMapping("/password-reset/complete") public ResponseEntity<Void> completeReset(@RequestBody AuthModels.ResetCompleteRequest request){auth.completePasswordReset(request.userId(),request.code(),request.newPassword());return ResponseEntity.noContent().build();}
 @PatchMapping("/profile") public AuthModels.UserDetails updateProfile(@AuthenticationPrincipal Jwt jwt,@RequestBody com.northstar.banking.model.ProductModels.ProfileUpdate request){return auth.updateProfile(jwt.getSubject(),request.name(),request.mobileNo(),request.emailId());}
 @GetMapping("/me") public AuthModels.UserDetails me(@AuthenticationPrincipal Jwt jwt){DigitalUser u=users.findByUserIdIgnoreCase(jwt.getSubject()).orElseThrow();return u.toUserDetails();}
 @ExceptionHandler(PasswordResetEmailService.MailDeliveryFailure.class) public ResponseEntity<AuthModels.ErrorResponse> mailFailure(PasswordResetEmailService.MailDeliveryFailure ex){return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new AuthModels.ErrorResponse(ex.getMessage()));}
 @ExceptionHandler(AuthService.AuthFailure.class) public ResponseEntity<AuthModels.ErrorResponse> failure(AuthService.AuthFailure ex){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthModels.ErrorResponse(ex.getMessage()));}
}
