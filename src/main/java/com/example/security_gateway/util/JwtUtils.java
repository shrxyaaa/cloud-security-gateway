package com.example.security_gateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;

@Component
public class JwtUtils {
    // This key must be long!
    private static final String SECRET = "my_super_secret_key_for_digital_signatures_256_bits_long";

    public void validateToken(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
        Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token); // Fails if tampered with
    }
}