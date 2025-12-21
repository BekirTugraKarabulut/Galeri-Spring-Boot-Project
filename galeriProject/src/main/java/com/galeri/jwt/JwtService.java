package com.galeri.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    public static final String SECRET_KEY = "eDks42KaKsqniLPE3++YIkeYnwnJE9B15mvAjNK0eNk=";

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getKey() , SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token){

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    public <T> T exportToken(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = getClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String getUsernameByToken(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public boolean isValidToken(String token){
        return new Date().before(getClaims(token).getExpiration());
    }

    public Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
