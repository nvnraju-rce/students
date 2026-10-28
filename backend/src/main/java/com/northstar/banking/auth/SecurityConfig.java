package com.northstar.banking.auth;
import com.nimbusds.jose.jwk.*;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
@Configuration
public class SecurityConfig {
 @Bean SecretKey jwtSecretKey(){byte[] key=new byte[32];new SecureRandom().nextBytes(key);return new SecretKeySpec(key,"HmacSHA256");}
 @Bean JwtEncoder jwtEncoder(SecretKey key){JWK jwk=new OctetSequenceKey.Builder(key).keyID("northstar-session-key").build();return new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));}
 @Bean JwtDecoder jwtDecoder(SecretKey key){return NimbusJwtDecoder.withSecretKey(key).macAlgorithm(org.springframework.security.oauth2.jose.jws.MacAlgorithm.HS256).build();}
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder(12);}
 @Bean SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{return http.csrf(c->c.disable()).formLogin(c->c.disable()).httpBasic(c->c.disable()).sessionManagement(c->c.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(a->a.requestMatchers(HttpMethod.POST,"/api/auth/login","/api/auth/password-reset/request","/api/auth/password-reset/complete").permitAll().requestMatchers("/api/health").permitAll().requestMatchers("/api/**").authenticated().anyRequest().permitAll()).oauth2ResourceServer(o->o.jwt(Customizer.withDefaults())).build();}
 @Bean org.springframework.boot.CommandLineRunner seedDemoUser(DigitalUserRepository users,PasswordEncoder encoder){return args->{DigitalUser user=users.findByUserIdIgnoreCase("demo").orElse(null);if(user==null)users.save(new DigitalUser("demo","Account Holder","0000000000","demo@northstar.local",encoder.encode("Demo@12345"),true));else if("Aarav Mehta".equals(user.getName())){user.updateProfile("Account Holder",user.getMobileNo(),user.getEmailId());users.save(user);}};}
}
