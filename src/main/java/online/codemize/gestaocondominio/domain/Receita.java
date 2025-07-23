package online.codemize.gestaocondominio.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "receitas")
public class Receita extends Domain{

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String categoria;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
