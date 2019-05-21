package com.server.ami.config;


import com.server.ami.entity.Utilisateur;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;


@Component
public class JwtGenerator {


    public String generate(Utilisateur jwtUser) {

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getEmail());
        claims.put("password", jwtUser.getPassword());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "Efive")
                .compact();
    }
}
