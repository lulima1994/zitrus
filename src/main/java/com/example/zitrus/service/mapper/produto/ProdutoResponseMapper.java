package com.example.zitrus.service.mapper.produto;

import com.example.zitrus.domain.model.Produto;
import com.example.zitrus.dto.produto.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoResponseMapper {
    public ProdutoResponse mapearResponse(Produto produto) {
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setId(produto.getId());
        produtoResponse.setCodigo(produto.getCodigo());
        produtoResponse.setDescricao(produto.getDescricao());
        produtoResponse.setTipoProduto(produto.getTipoProduto());
        produtoResponse.setValorFornecedor(produto.getValorFornecedor());
        produtoResponse.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return produtoResponse;
    }
}
