package online.codemize.gestaocondominio.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(@NotBlank String nome,
                             @NotBlank String email,
                             @NotBlank String senha,
                             boolean permiteEscrita) {
}
