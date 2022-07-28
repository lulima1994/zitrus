package com.example.zitrus.dto.produto;


import com.example.zitrus.domain.model.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TipoProdutoResponse {
    private Long id;
    private String codigo;
    private String descricao;
    private TipoProduto tipoProduto;
    private BigDecimal valorFornecedor;
    private Integer quantidadeDisponivel;
    private Integer quantidadeSaida;
}
