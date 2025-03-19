package com.example.biblioteca.component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "clave secreta";

    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public String extraerUsername(String token) {
        return obtenerClaims(token).getSubject();
    }
    public boolean validarToken(String token, String username) {
        return extraerUsername(token).equals(username) && !tokenExpirado(token);
    }
    public boolean tokenExpirado(String token) {
        return obtenerClaims(token).getExpiration().before(new Date());
    }
    public Claims obtenerClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

}
