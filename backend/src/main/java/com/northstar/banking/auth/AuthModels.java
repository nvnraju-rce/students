package com.northstar.banking.auth;
public final class AuthModels {
 private AuthModels() {}
 public record LoginRequest(String userId,String password) {}
 public record UserDetails(String userId,String name,String mobileNo,String emailId,String initials,String customerId,String memberSince) {}
 public record LoginResponse(String accessToken,String tokenType,long expiresIn,UserDetails user) {}
 public record ErrorResponse(String message) {}
 public record ResetRequest(String userId,String emailId) {}
 public record ResetRequestResponse(String message) {}
 public record ResetCompleteRequest(String userId,String code,String newPassword) {}
}
