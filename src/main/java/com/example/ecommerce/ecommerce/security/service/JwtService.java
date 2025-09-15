package com.example.ecommerce.ecommerce.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
public class JwtService {

    private final String secretKey ;

    @Autowired
    public JwtService(@Value("${spring.security.private}") String secretKey){
        this.secretKey = secretKey;
    }

    public String extractUsername(String token) {
        return extractClailm(token,Claims::getSubject);
    }

    public String generateToken(String userName,Map<String, Object> claims){
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .and()
                .signWith(getSignInKey(),Jwts.SIG.HS256)
                .compact();
    }

    public <T> T extractClailm(String token, Function<Claims,T> claimResolver){
        final Claims claims = extractAllClailm(token);
        return claimResolver.apply(claims);
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String userName=extractUserName(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClailm(token, Claims::getExpiration);
    }

    private String extractUserName(String token) {
        return extractClailm(token, Claims::getSubject);
    }

    private Claims extractAllClailm(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

}
