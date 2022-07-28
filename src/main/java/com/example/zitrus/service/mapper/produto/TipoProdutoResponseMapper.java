package com.example.zitrus.service.mapper.produto;

import com.example.zitrus.domain.model.Produto;
import com.example.zitrus.dto.produto.TipoProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoProdutoResponseMapper {
    public TipoProdutoResponse mapearResponse(Produto produto) {
        TipoProdutoResponse tipoProdutoResponse = new TipoProdutoResponse();
        tipoProdutoResponse.setId(produto.getId());
        tipoProdutoResponse.setCodigo(produto.getCodigo());
        tipoProdutoResponse.setDescricao(produto.getDescricao());
        tipoProdutoResponse.setTipoProduto(produto.getTipoProduto());
        tipoProdutoResponse.setValorFornecedor(produto.getValorFornecedor());
        tipoProdutoResponse.setQuantidadeDisponivel(produto.getQuantidadeEstoque());
        tipoProdutoResponse.setQuantidadeSaida(produto.getQuantidadeSaida());
        return tipoProdutoResponse;
    }
}