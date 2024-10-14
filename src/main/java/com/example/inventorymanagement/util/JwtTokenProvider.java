package com.example.inventorymanagement.util;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private Key secretKey;

    // 从 application.properties 中读取密钥
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token-validity-in-seconds}")
    private long validityInMilliseconds; // token 有效时间

    // 初始化方法，Spring 启动时会调用
    @PostConstruct
    public void init() {
        // 使用更强的密钥生成方式，确保密钥符合 HS256 的要求
        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // 创建 JWT token
    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);

        // 生成 token 的有效期
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        // 生成并返回 JWT
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // Subject 通常是 email 或用户名
    }

    // 验证 token 是否有效
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 从 token 中获取用户名
    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}