package online.codemize.gestaocondominio.domain;

import lombok.Getter;
import lombok.Setter;
import online.codemize.gestaocondominio.domain.enums.StatusDespesa;

import java.time.LocalDate;

@Getter
@Setter
public class Despesa {

    private Integer id;
    private String categoria;
    private String descricao;
    private Double valorOriginal;
    private Double valorPago;
    private LocalDate dataCriacao;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private StatusDespesa status;


}
