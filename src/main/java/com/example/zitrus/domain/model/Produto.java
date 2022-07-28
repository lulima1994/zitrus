package com.example.zitrus.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String codigo;
    @Column(nullable = false, length = 450)
    private String descricao;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;
    @Column(nullable = false)
    private BigDecimal valorFornecedor;
    @Column(nullable = false)
    private Integer quantidadeEstoque;
    @Column(nullable = false)
    private Integer quantidadeSaida;
    @Column(nullable = false)
    private BigDecimal lucro;
}
