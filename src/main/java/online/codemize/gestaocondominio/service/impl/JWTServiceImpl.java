package online.codemize.gestaocondominio.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioPayload;
import online.codemize.gestaocondominio.oauth.UsuarioClaims;
import online.codemize.gestaocondominio.service.JWTService;
import online.codemize.gestaocondominio.utils.AppMessages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService {

    @Value("${app.token.expiration}")
    private Integer tokenExpirationSeconds;

    @Value("${app.token.signing_key}")
    private String chaveAssinaturaToken;

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
    public String validarTokenAndGetEmailUsuario(String token) {
        var payloadClaims = Jwts
                .parser()
                .verifyWith(obterSecretKey())
                .build()
                .parseSignedClaims(token);
        verificarExpiracaoToken(payloadClaims);
        return payloadClaims.getPayload().get(UsuarioClaims.email.name(), String.class);
    }

    private void verificarExpiracaoToken(Jws<Claims> claims){
        Date dtExpiracaoToken = claims.getPayload().getExpiration();
        var agora = new Date();
        if(agora.after(dtExpiracaoToken))
            throw new JwtException(AppMessages.TPKEN_EXPIRADO_ERRO);
    }

    private Map<String, Object> contruirPayload(Usuario usuario){
        Map<String, Object> mapa = new HashMap<>();
        mapa.put(UsuarioClaims.email.name(), usuario.getEmail());
        mapa.put(UsuarioClaims.admin.name(), usuario.getAdmin());
        return mapa;
    }

    private Date obterDataExpiracaoToken(){
        var instant = Instant.now();
        var expiration = instant.plusSeconds(tokenExpirationSeconds);
        return  Date.from(expiration);
    }

    private SecretKey obterSecretKey(){
        return Keys.hmacShaKeyFor(chaveAssinaturaToken.getBytes());
    }

}
