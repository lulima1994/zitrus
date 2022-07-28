package com.example.zitrus.dto.movimentoestoque;

import com.example.zitrus.domain.model.TipoMovimento;
import com.example.zitrus.dto.produto.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class MovimentoEstoqueResponse {
    private Long id;
    private ProdutoResponse produtoResponse;
    private TipoMovimento tipoMovimento;
    private BigDecimal valorVenda;
    private LocalDateTime dataVenda;
    private Integer quantidadeMovimentada;
}
