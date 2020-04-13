//package com.fly.configuration.security.utils;
//
//import com.fly.configuration.security.TokenConfiguration;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import static java.util.Calendar.MILLISECOND;
//
//@Component
//@RequiredArgsConstructor
//public class TokenUtils {
//
//    private final TokenConfiguration tokenConfig;
//
//    public String getUsernameFromToken (String token)
//
//    public String generateToken(UserDetails userDetails){
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("sub", userDetails.getUsername());
//        claims.put("created", this.generateCurrentDate());
//        claims.put("role", getEncryptedRoles(userDetails));
//        return generateToken(claims);
//
//    }
//
//    private Date generateCurrentDate() {
//        return new Date();
//    }
//
//    private List<String> getEncryptedRoles(UserDetails userDetails) {
//        return userDetails.getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .map(s -> s.replace("ROLE_", ""))
//                .map(String::toLowerCase)
//                .collect(Collectors.toList());
//    }
//    private String generateToken(Map<String, Object> claims){
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
//                .signWith(SignatureAlgorithm.ES512, tokenConfig.getSshSecret())
//                .compact();
//
//    }
//
//    private Date generateExpirationDate() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(MILLISECOND, Integer.valueOf(tokenConfig.getExpirationTime()));
//        return calendar.getTime();
//    }
//
//
//}
