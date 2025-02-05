package com.twopiradrian.auth_server.config.helpers;

import com.twopiradrian.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTHelper {

    @Value("${application.jwt.secret}")
    private String secret;

    @Value("${application.jwt.expiration}")
    private Long expiration;

    public boolean validateToken(String token) {
        final var expirationDate = this.getExpirationDate(token);

        return expirationDate.after(new Date());
    }

    public String getSubject(String token) {
        return this.getClaims(token, Claims::getSubject);
    }

    public String createToken (User user) {
        final var now = new Date();
        final var expirationDate = new Date(now.getTime() + this.expiration);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(this.getSecretKey())
                .compact();
    }

    private Date getExpirationDate(String token) {
        return this.getClaims(token, Claims::getExpiration);
    }

    private <T> T getClaims(String token, Function<Claims, T> resolver) {
        // gets the claims from the token and signs it
        return resolver.apply(this.signToken(token));
    }

    private Claims signToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));
    }

}
