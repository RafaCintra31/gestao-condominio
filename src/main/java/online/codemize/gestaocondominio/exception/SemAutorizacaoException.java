package online.codemize.gestaocondominio.exception;

public class SemAutorizacaoException extends RuntimeException{

    public SemAutorizacaoException(String mensagem){
        super(mensagem);
    }
}
