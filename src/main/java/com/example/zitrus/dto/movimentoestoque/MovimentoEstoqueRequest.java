package com.example.zitrus.dto.movimentoestoque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class MovimentoEstoqueRequest {
    private Long id;
    private String codigo;
    private Integer quantidadeMovimentada;
}
