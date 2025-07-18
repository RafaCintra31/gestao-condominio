package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioRequest;

public interface UsuarioService {

    void criar(UsuarioRequest request);

    Usuario obterUsuario(String email);

    void atualizarSenha(String email, String novaSenha);

    void associarUnidade(String emailUsuario, String registroUnidade);

}
