package online.codemize.gestaocondominio.dto;

public record UsuarioRequest(String nome,
                             String email,
                             String senha,
                             boolean permiteEscrita) {
}
