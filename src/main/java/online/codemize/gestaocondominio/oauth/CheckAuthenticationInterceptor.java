package online.codemize.gestaocondominio.oauth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CheckAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        var token = request.getHeader("token-app");
        var isTokenValido = token != null && token.equals("abc123");

        if(isTokenValido)
            return true;

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write("Você não tem autorização para acessar este serviço");
        return false;
    }
}
