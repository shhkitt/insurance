package shhkitt.rschir.kr.insurance.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import shhkitt.rschir.kr.insurance.models.entity.Client;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtProvider {
    private SecretKey jwtAccessSecret;

    public JwtProvider() {
        jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode("verysecretsecret1secretsupersecretkeyaaaaaaaaaaaaaaaaaaaaaa"));

    }

    public String generateToken(Client client) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(10).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        String str = Jwts.builder()
                .setSubject(client.email)
                .setExpiration(accessExpiration)
                .signWith(jwtAccessSecret)
                .claim("role", client.role)
                .claim("email", client.getEmail())
                .claim("id", client.id)
                .compact();
        System.out.println(Jwts.parserBuilder()
                .setSigningKey(jwtAccessSecret)
                .build()
                .parse(str)
                .getBody().toString()
        );
        return str;

    }
    public Claims validateToken(String token) {
        try {
            Object claims = Jwts.parserBuilder()
                    .setSigningKey(jwtAccessSecret)
                    .build()
                    .parse(token)
                    .getBody();
            return (io.jsonwebtoken.Claims) claims;

        }
        catch (ExpiredJwtException expEx) {
            System.out.println("Token expired" + expEx);
            throw expEx;
        } catch (UnsupportedJwtException unsEx) {
            System.out.println("Unsupported jwt" +unsEx);
        } catch (MalformedJwtException mjEx) {
            System.out.println("Malformed jwt" + mjEx);
        } catch (SignatureException sEx) {
            System.out.println("Invalid signature" +sEx);
        } catch (Exception e) {
            System.out.println("invalid token" + e);
        }
        return null;
    }



}