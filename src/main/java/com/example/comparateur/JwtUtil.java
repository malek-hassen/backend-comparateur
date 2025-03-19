package com.example.comparateur;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.logging.Logger;

@Component
public class JwtUtil {

    private Key key;

    @Value("${jwt.expiration}")
    private long expirationTime;

    @PostConstruct
    public void init() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
    private static final Logger logger = Logger.getLogger(JwtUtil.class.getName());

    public String generateToken(String username) {
       try {
           String token = Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                   .signWith(key)
                   .compact();

           logger.info("Generated JWT Token: " + token);  // Add this line for logging
           return token;
       }catch (Exception e) {
           System.err.println("Failed to generate JWT token: " + e.getMessage()); // Debugging output
           e.printStackTrace();
           throw e;
       }
    }


    public String extractUsername(String token) {
        System.out.println("Extracting username from token...");
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, String username) {
        boolean valid = (extractUsername(token).equals(username) && !isTokenExpired(token));
        System.out.println("Token validation result: " + valid);
        return valid;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
