package online.codemize.gestaocondominio.oauth;

import lombok.Getter;
import lombok.Setter;
import online.codemize.gestaocondominio.domain.Usuario;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsuarioAppContext {

    private Usuario usuario;

}
