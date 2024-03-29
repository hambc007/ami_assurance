package com.server.ami.config;

import com.server.ami.entity.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "Efive";

    public Utilisateur validate(String token) {

        Utilisateur jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new Utilisateur();
            jwtUser.setEmail(body.getSubject());
            jwtUser.setPassword((String) body.get("password"));
            // body.get("role")
            //jwtUser.setRole((Role) new Role(body.get("role").toString()));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
