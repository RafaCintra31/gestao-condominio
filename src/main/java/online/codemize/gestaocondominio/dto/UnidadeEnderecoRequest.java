package online.codemize.gestaocondominio.dto;

import online.codemize.gestaocondominio.domain.Unidade;

public record UnidadeEnderecoRequest(Long unidadeId,
                                     String cep,
                                     String numero,
                                     String complemento) {
}
