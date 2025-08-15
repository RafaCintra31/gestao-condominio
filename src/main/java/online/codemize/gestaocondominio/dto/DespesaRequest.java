package online.codemize.gestaocondominio.dto;

public record DespesaRequest(String categoria,
                             String descricao,
                             Double valorOriginal,
                             Double valorPago,
                             String dataPagamento,
                             String dataVencimento){
}
