package online.codemize.gestaocondominio.dto;

public record DespesaRequest(Long idUsuario,
                             String categoria,
                             String descricao,
                             Double valorOriginal,
                             Double valorPago,
                             String dataPagamento,
                             String dataVencimento){
}
