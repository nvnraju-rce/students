package com.northstar.banking.auth;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "digital_user", indexes = @Index(name="idx_digital_user_user_id", columnList="user_id", unique=true))
public class DigitalUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="user_id", nullable=false, unique=true, length=80) private String userId;
 @Column(nullable=false, length=120) private String name;
 @Column(name="mobile_no", nullable=false, length=25) private String mobileNo;
 @Column(name="email_id", nullable=false, length=180) private String emailId;
 @Column(name="customer_id", length=40) private String customerId;
 @Column(name="member_since", length=4) private String memberSince;
 @Column(name="password_hash", nullable=false, length=100) private String passwordHash;
 @Column(name="failed_attempts", nullable=false) private int failedAttempts;
 @Column(name="lock_flag", nullable=false) private boolean lockFlag;
 @Column(name="active_flag", nullable=false) private boolean activeFlag;
 @Column(name="locked_until") private Instant lockedUntil;
 @Column(name="last_login_at") private Instant lastLoginAt;
 protected DigitalUser() {}
 public DigitalUser(String userId,String name,String mobileNo,String emailId,String passwordHash,boolean activeFlag){this.userId=userId;this.name=name;this.mobileNo=mobileNo;this.emailId=emailId;this.passwordHash=passwordHash;this.activeFlag=activeFlag;this.customerId="demo".equalsIgnoreCase(userId)?"DEMO-10042":"USER-"+userId.toUpperCase();this.memberSince="demo".equalsIgnoreCase(userId)?"2023":String.valueOf(java.time.Year.now().getValue());}
 public Long getId(){return id;} public String getUserId(){return userId;} public String getName(){return name;} public String getMobileNo(){return mobileNo;} public String getEmailId(){return emailId;} public String getPasswordHash(){return passwordHash;} public int getFailedAttempts(){return failedAttempts;} public boolean isLockFlag(){return lockFlag;} public boolean isActiveFlag(){return activeFlag;} public Instant getLockedUntil(){return lockedUntil;} public Instant getLastLoginAt(){return lastLoginAt;}
 public AuthModels.UserDetails toUserDetails(){String[] parts=name==null?new String[0]:name.trim().split("\\s+");String initials=parts.length>1?(parts[0].substring(0,1)+parts[parts.length-1].substring(0,1)).toUpperCase():(name==null||name.isBlank()?"U":name.substring(0,Math.min(2,name.length())).toUpperCase());String customer=customerId==null?("demo".equalsIgnoreCase(userId)?"DEMO-10042":"USER-"+userId.toUpperCase()):customerId;String since=memberSince==null?String.valueOf(java.time.Year.now().getValue()):memberSince;return new AuthModels.UserDetails(userId,name,mobileNo,emailId,initials,customer,since);}
 public void updateProfile(String name,String mobileNo,String emailId){this.name=name;this.mobileNo=mobileNo;this.emailId=emailId;}
 public void changePassword(String hash){this.passwordHash=hash;this.failedAttempts=0;this.lockFlag=false;this.lockedUntil=null;}
 public void recordFailure(int max,Instant until){failedAttempts++; if(failedAttempts>=max){lockFlag=true;lockedUntil=until;}}
 public void unlockExpired(){lockFlag=false;failedAttempts=0;lockedUntil=null;}
 public void recordSuccess(Instant now){failedAttempts=0;lockFlag=false;lockedUntil=null;lastLoginAt=now;}
}
