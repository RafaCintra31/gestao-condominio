package online.codemize.gestaocondominio.converter;

import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UsuarioConverter implements Function<UsuarioRequest, Usuario> {

    @Override
    public Usuario apply(UsuarioRequest request) {

        var usuario = new Usuario();
        BeanUtils.copyProperties(request, usuario);
        usuario.setSenha(BCrypt.hashpw(request.senha(), BCrypt.gensalt()));
        return usuario;
    }
}
