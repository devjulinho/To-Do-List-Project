package br.com.devjulinho.todolist.domain.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.MalformedJwtException;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;

public class AuthenticationService {
    public static final long EXPIRATIONTIME = 1000*60*15;
    public static final String SIGNINKEY = "O segredo precisa ser longo";
    public static final String PREFIX = "Bearer";
    private static final SecretKey SECRETKEY = Keys.hmacShaKeyFor(SIGNINKEY.getBytes());

    public static void addToken(HttpServletResponse res, String email){
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATIONTIME);
        String JwtToken = Jwts.builder()
                .claim("sub", email)
                .claim("iat", now.getTime()) //issued at
                .claim("exp", expirationDate.getTime())
                .signWith(SECRETKEY)
                .compact();

        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    public static Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token != null){
            if (token.startsWith(PREFIX))
                token = token.substring(PREFIX.length()).trim();
            else
                throw new MalformedJwtException("Invalid Authorization header format");
            Claims claims = Jwts.parser()
                    .verifyWith(SECRETKEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String email = claims.get("sub", String.class);
            if(email != null)
                return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }
        return null;
    }

}
