package online.codemize.gestaocondominio.exception;

public class UnidadeNotFoundException extends RuntimeException{

    public UnidadeNotFoundException(){
        super("A unidade não foi encontrado");
    }
}
