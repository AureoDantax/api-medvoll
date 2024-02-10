package br.com.med.voll.api.config.security;

import br.com.med.voll.api.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Slf4j
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(Usuario usuario) {

        try {
            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.create().
                    withIssuer("voll.med API").
                    withExpiresAt(expiracaoToken()).
                    withSubject(usuario.getLogin()).
                    sign(algoritmo);

        } catch (JWTCreationException ex) {
            log.error("falha ao gerar token, motivo:  " + ex);
            throw new JWTCreationException("falha ao gerar token, motivo:  ", ex);
        }


    }


    public String getSubject(String jwt) {


        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("voll.med API")
                    .build()
                    .verify(jwt)
                    .getSubject();
        } catch (JWTDecodeException ex) {
            log.error("falha ao validar token, motivo:  " + ex);
            throw new JWTCreationException("falha ao validar token, motivo:  ", ex);
        }
    }
    private Instant expiracaoToken() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
}
