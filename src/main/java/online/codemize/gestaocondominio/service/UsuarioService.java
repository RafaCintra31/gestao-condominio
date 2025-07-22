package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioRequest;

public interface UsuarioService {

    void criar(UsuarioRequest request);

    Usuario obterUsuario(String email);

    Usuario obterUsuario(Long idUsuario);

    void atualizarSenha(String email, String novaSenha);

    void associarUnidade(String emailUsuario, String registroUnidade);

}
