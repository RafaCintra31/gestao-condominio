package online.codemize.gestaocondominio.config;

import online.codemize.gestaocondominio.dto.ErrorResponse;
import online.codemize.gestaocondominio.exception.CriacaoUsuarioException;
import online.codemize.gestaocondominio.exception.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(CriacaoUsuarioException.class)
    public ResponseEntity<ErrorResponse> handler(CriacaoUsuarioException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(UsuarioNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }

}
