package com.atguigu.ssyx.common.utils;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class JwtUtils {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512); // 自动生成的密钥
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 *2; // 有效期为 10 天，以毫秒为单位
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHOdnsmandsmlahndjksalndasfgdlsakjnhfdlkafdsfsdf";//秘钥
    // 生成 JWT
    public static String generateToken(String username) {
        String JwtToken = Jwts.builder()
                //设置Jwt头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //设置字符串的过期时间
                .setSubject("guli-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))

                .claim("username", username)

                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    // 解析 JWT
    public static String getUsernameFromToken(String token) {
        if(StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("username");
    }

    // 验证 JWT 是否有效
    public static boolean validateToken(String token) {
        if(StringUtils.isEmpty(token)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}