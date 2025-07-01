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
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDespesa status;


}
