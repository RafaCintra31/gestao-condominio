package online.codemize.gestaocondominio.config;

import online.codemize.gestaocondominio.dto.ErrorResponse;
import online.codemize.gestaocondominio.exception.*;
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
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(ReceitaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(ReceitaNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(UnidadeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(UnidadeNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(AssociacaoUsuarioUnidadeException.class)
    public ResponseEntity<ErrorResponse> handler(AssociacaoUsuarioUnidadeException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }
}
