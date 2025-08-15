package online.codemize.gestaocondominio.dto;

public record ReceitaRequest(String descricao,
                             String dataPagamento,
                             String dataVencimento,
                             Double valor,
                             String categoria,
                             Long idUnidade) {
}
