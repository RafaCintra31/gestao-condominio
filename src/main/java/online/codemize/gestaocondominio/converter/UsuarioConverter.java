package online.codemize.gestaocondominio.converter;

import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UsuarioConverter implements Function<UsuarioRequest, Usuario> {

    @Override
    public Usuario apply(UsuarioRequest request) {
        String senha = BCrypt.hashpw(request.senha(), BCrypt.gensalt());

        var usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setPermiteEscrita(request.permiteEscrita());
        usuario.setSenha(senha);

        return usuario;
    }
}
