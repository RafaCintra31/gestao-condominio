package online.codemize.gestaocondominio.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioPayload;
import online.codemize.gestaocondominio.service.JWTService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService {

    private static final String CHAVE_ASSINATURA_TOKEN = "39v03Un7qJ+ZUryA2zQ9XznLKqbyXymeL9UVqUvAkdchrToT8Aw/6jiyt+z0crSM3GPxnztwdG6I3fY+ymhH0w==";

    @Override
    public String gerarTokenAcesso(Usuario usuario) {
        return Jwts
                .builder()
                .subject(usuario.getNome())
                .claims(contruirPayload(usuario))
                .issuedAt(Date.from(Instant.now()))
                .expiration(obterDataExpiracaoToken())
                .signWith(obterSecretKey())
                .compact();

    }

    @Override
    public void validarToken(String token) {
        var payloadClaims = Jwts
                .parser()
                .verifyWith(obterSecretKey())
                .build()
                .parseSignedClaims(token);

        verificarExpiracaoToken(payloadClaims);
    }

    private void verificarExpiracaoToken(Jws<Claims> claims){
        Date dtExpiracaoToken = claims.getPayload().getExpiration();
        var agora = new Date();
        if(agora.after(dtExpiracaoToken))
            throw new JwtException("Token expirado");
    }

    private Map<String, Object> contruirPayload(Usuario usuario){
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("email", usuario.getEmail());
        mapa.put("admin", usuario.getAdmin());
        return mapa;
    }

    private Date obterDataExpiracaoToken(){
        var instant = Instant.now();
        var expiration = instant.plusSeconds(60);
        return  Date.from(expiration);
    }

    private SecretKey obterSecretKey(){
        return Keys.hmacShaKeyFor(CHAVE_ASSINATURA_TOKEN.getBytes());
    }

}
