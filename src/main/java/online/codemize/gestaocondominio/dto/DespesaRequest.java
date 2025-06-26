package online.codemize.gestaocondominio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DespesaRequest {

    private String categoria;
    private String descricao;
    private Double valorOriginal;
    private Double valorPago;
    private String dataPagamento;
    private String dataVencimento;

}
