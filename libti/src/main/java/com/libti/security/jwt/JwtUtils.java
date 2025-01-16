package com.libti.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.libti.services.UserDetailsImpls;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    
    @Value("${libti.app.jwtSecret}")
    private String jwtSecret;

    @Value("${libti.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateTokenFromUserDetailsImpl(UserDetailsImpls UserDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", UserDetails.getId());
        
        return Jwts.builder()
                .setClaims(claims)
                .setSubject((UserDetails.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public Key getSigningKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public String getEmailToken(String token){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Claims claims = 
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken).getBody();
            System.out.println("Claims: "+claims);
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } 
        return false;
    }
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build().parseClaimsJws(token)
                    .getBody();
    }
    public UUID getIdFromToken(String token) {
        Claims claims = getClaims(token);
        String idString = claims.get("id", String.class);
        return UUID.fromString(idString);
    }
}
