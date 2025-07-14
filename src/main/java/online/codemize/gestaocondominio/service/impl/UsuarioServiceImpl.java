package online.codemize.gestaocondominio.service.impl;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioRequest;
import online.codemize.gestaocondominio.exception.CriacaoUsuarioException;
import online.codemize.gestaocondominio.repository.UsuarioRepository;
import online.codemize.gestaocondominio.service.UsuarioService;
import online.codemize.gestaocondominio.utils.AppUtil;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public void criar(UsuarioRequest request) {
        if(AppUtil.isEmailInvalid(request.email())){
            throw new CriacaoUsuarioException("email invalido");
        }

        String senha = BCrypt.hashpw(request.senha(), BCrypt.gensalt());

        var usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setPermiteEscrita(request.permiteEscrita());
        usuario.setSenha(senha);

        repository.save(usuario);
    }

    @Override
    public Usuario obterUser(String email) {
        return null;
    }

    @Override
    public void atualizarSenha(String email, String novaSenha) {

    }

}
