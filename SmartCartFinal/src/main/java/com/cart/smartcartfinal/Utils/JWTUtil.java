package com.cart.smartcartfinal.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtil {

    private static String Signature = "FireFly520";
    private static long ExpireTime = 600 * 1000;

    public static String CreateJWT(Map<String, Object> claims)
    {
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, Signature)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + ExpireTime))
                .compact();
        return jwt;
    }

    public static Claims ParseJWT(String jwt)
    {
        Claims claims = Jwts.parser()
                .setSigningKey(Signature)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

}
