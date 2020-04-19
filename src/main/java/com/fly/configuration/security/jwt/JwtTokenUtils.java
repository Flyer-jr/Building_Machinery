package com.fly.configuration.security.jwt;

import com.fly.configuration.security.TokenConfiguration;
import com.fly.controller.requests.authentication.UserPrincipal;
import com.fly.controller.requests.user.UserCreateRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.jsonwebtoken.Claims.SUBJECT;
import static java.util.Calendar.MILLISECOND;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenUtils {

    private static final String CREATED = "created";
    private static final String ROLE = "role";

    private final TokenConfiguration tokenConfig;

    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Map<String, Object> claims = generateClaims(userPrincipal);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, tokenConfig.getSshSecret())
                .compact();
    }

    public String generateConfirmationToken(UserCreateRequest request) {
        return Jwts.builder()
                .setSubject(request.getLogin())
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, tokenConfig.getSshSecret())
                .compact();
    }

    private Date generateExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(MILLISECOND, Integer.parseInt(tokenConfig.getExpirationTime()));
        return calendar.getTime();
    }

    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims =
                    Jwts.parser().setSigningKey(tokenConfig.getSshSecret()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String getUsernameFromToken(String token) {

        return getClaimsFromToken(token).getSubject();
    }

    public Map<String, Object> generateClaims(UserPrincipal userPrincipal) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(SUBJECT, userPrincipal.getUsername());
        claims.put(CREATED, new Date());
        claims.put(ROLE, getRoles(userPrincipal));
        return claims;

    }

    private List<String> getRoles(UserPrincipal userPrincipal) {
        return userPrincipal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .map(s -> s.replace("ROLE_", ""))
                .collect(Collectors.toList());
    }


    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(tokenConfig.getSshSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      log.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      log.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      log.error("JWT claims string is empty.");
    }
    return false;
  }
}
