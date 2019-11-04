package com.example.lietenerbox.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;


public class JwtUtil {

    private Key key;

    public JwtUtil(String secret){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }




    public String createToken(Long memSn, String memName) {
        //자바의 key 사용, 키생성
        String token = Jwts.builder()
                .claim("memSn", memSn)
                .claim("memName", memName)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
}
