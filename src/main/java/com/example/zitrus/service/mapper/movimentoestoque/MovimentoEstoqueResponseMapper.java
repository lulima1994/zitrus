package com.example.zitrus.service.mapper.movimentoestoque;

import com.example.zitrus.domain.model.MovimentoEstoque;
import com.example.zitrus.domain.model.TipoMovimento;
import com.example.zitrus.dto.movimentoestoque.MovimentoEstoqueResponse;
import com.example.zitrus.service.mapper.produto.ProdutoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MovimentoEstoqueResponseMapper {
    private final ProdutoResponseMapper produtoResponseMapper;

    public MovimentoEstoqueResponse mapearResponse(MovimentoEstoque movimentoEstoque) {
        MovimentoEstoqueResponse movimentoEstoqueResponse = new MovimentoEstoqueResponse();
        movimentoEstoqueResponse.setId(movimentoEstoque.getId());
        movimentoEstoqueResponse.setProdutoResponse(produtoResponseMapper.mapearResponse(movimentoEstoque.getProduto()));
        movimentoEstoqueResponse.setTipoMovimento(TipoMovimento.SAIDA);
        movimentoEstoqueResponse.setValorVenda(calcularVenda(movimentoEstoque));
        movimentoEstoqueResponse.setDataVenda(LocalDateTime.now());
        movimentoEstoqueResponse.setQuantidadeMovimentada(movimentoEstoque.getQuantidadeMovimentada());
        return movimentoEstoqueResponse;
    }

    public BigDecimal calcularVenda(MovimentoEstoque movimentoEstoque) {
        return movimentoEstoque.getProduto().getValorFornecedor()
                .add(movimentoEstoque.getProduto().getValorFornecedor()
                        .multiply(movimentoEstoque.getProduto().getTipoProduto().getValor()));
    }
}
