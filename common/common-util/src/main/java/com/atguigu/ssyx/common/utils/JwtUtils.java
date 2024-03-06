package com.atguigu.ssyx.common.utils;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtils {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512); // 自动生成的密钥
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 *2; // 有效期为 10 天，以毫秒为单位

    // 生成 JWT
    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", username);
        claims.put("iat", now);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    // 解析 JWT
    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // 验证 JWT 是否有效
    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
