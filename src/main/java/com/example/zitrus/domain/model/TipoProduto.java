package com.example.zitrus.domain.model;

import java.math.BigDecimal;

public enum TipoProduto {
    ELETRONICO(BigDecimal.valueOf(0.5)),
    ELETRODOMESTICO(BigDecimal.valueOf(0.4)),
    MOVEL(BigDecimal.valueOf(0.3));

    private final BigDecimal valor;

    TipoProduto(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
