package com.example.zitrus.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class MovimentoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;
    @Column
    private BigDecimal valorVenda;
    @Column
    private LocalDateTime dataVenda;
    @Column(nullable = false)
    private Integer quantidadeMovimentada;
}
