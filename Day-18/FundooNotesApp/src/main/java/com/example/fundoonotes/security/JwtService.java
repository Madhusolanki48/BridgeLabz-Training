package com.example.fundoonotes.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {
    private static final String CACHE_PREFIX = "jwt:valid:";

    private final SecretKey secretKey;
    private final long expirationMs;
    private final StringRedisTemplate redisTemplate;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiration-ms}") long expirationMs,
                      ObjectProvider<StringRedisTemplate> redisTemplateProvider) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
        this.redisTemplate = redisTemplateProvider.getIfAvailable();
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(secretKey)
                .compact();
    }
    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean isTokenValid(String token) {
        return getEmailIfTokenValid(token).isPresent();
    }

    public Optional<String> getEmailIfTokenValid(String token) {
        String cacheKey = CACHE_PREFIX + token;
        String cachedEmail = getCachedTokenEmail(cacheKey);
        if (cachedEmail != null) {
            return Optional.of(cachedEmail);
        }

        try {
            String email = extractEmail(token);
            Date expiration = extractExpiration(token);
            long ttlMillis = expiration.getTime() - System.currentTimeMillis();
            if (ttlMillis <= 0) {
                return Optional.empty();
            }
            cacheValidToken(cacheKey, email, ttlMillis);
            return Optional.of(email);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
    }

    private String getCachedTokenEmail(String cacheKey) {
        if (redisTemplate == null) {
            return null;
        }
        try {
            return redisTemplate.opsForValue().get(cacheKey);
        } catch (RedisConnectionFailureException exception) {
            return null;
        }
    }

    private void cacheValidToken(String cacheKey, String email, long ttlMillis) {
        if (redisTemplate == null) {
            return;
        }
        try {
            redisTemplate.opsForValue().set(cacheKey, email, Duration.ofMillis(ttlMillis));
        } catch (RedisConnectionFailureException exception) {
        }
    }
}
