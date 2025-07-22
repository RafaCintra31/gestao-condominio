package online.codemize.gestaocondominio.domain;

import jakarta.persistence.*;
import lombok.*;
import online.codemize.gestaocondominio.domain.enums.StatusDespesa;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
    jatkarta = JPA
    Vamos usar uma lib chamada Hibernate (mapeamneto de banco de dados no java)
*/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "despesas")
public class Despesa extends Domain{

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "valor_original", nullable = false)
    private Double valorOriginal;

    @Column(name = "valor_pago")
    private Double valorPago;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDespesa status;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
