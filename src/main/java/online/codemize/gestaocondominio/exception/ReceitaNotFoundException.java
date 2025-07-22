package online.codemize.gestaocondominio.exception;

public class ReceitaNotFoundException extends RuntimeException{

    public ReceitaNotFoundException(){
        super("Receita não foi encontrado");
    }
}
