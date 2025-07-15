package online.codemize.gestaocondominio.exception;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(){
        super("Usuário não foi encontrado");
    }
}
