package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioPayload;

public interface JWTService {

    String gerarTokenAcesso(Usuario usuario);

    UsuarioPayload validarTokenExtrairPayload(String token);

}
