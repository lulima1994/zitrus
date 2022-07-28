package com.example.zitrus.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LucroProdutoResponse {
    private ProdutoResponse produtoResponse;
    private Integer quantidadeSaida;
    private BigDecimal lucro;
}
