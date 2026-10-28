package com.northstar.banking.auth;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import java.time.*;
@Service
public class JwtService {
 private final JwtEncoder encoder; public static final long TOKEN_TTL_SECONDS=1800;
 public JwtService(JwtEncoder encoder){this.encoder=encoder;}
 public AuthModels.LoginResponse issue(DigitalUser user){Instant now=Instant.now();String token=encoder.encode(JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(),JwtClaimsSet.builder().issuer("northstar-demo").subject(user.getUserId()).issuedAt(now).expiresAt(now.plusSeconds(TOKEN_TTL_SECONDS)).claim("name",user.getName()).build())).getTokenValue();return new AuthModels.LoginResponse(token,"Bearer",TOKEN_TTL_SECONDS,user.toUserDetails());}
}
