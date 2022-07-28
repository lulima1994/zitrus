package com.example.zitrus.service.mapper.produto;

import com.example.zitrus.domain.model.Produto;
import com.example.zitrus.domain.repository.ProdutoRepository;
import com.example.zitrus.dto.produto.ProdutoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {
    private final ProdutoRepository produtoRepository;

    public Produto mapearRequest(ProdutoRequest produtoRequest) {
        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(produtoRequest.getCodigo());
        Produto produto = produtoOptional.orElse(new Produto());

        if (produtoOptional.isEmpty()) {
            produto.setCodigo(produtoRequest.getCodigo());
            produto.setQuantidadeEstoque(produtoRequest.getQuantidadeEstoque());
            produto.setQuantidadeSaida(0);
            produto.setLucro(BigDecimal.ZERO);
        } else
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + produtoRequest.getQuantidadeEstoque());

        produto.setDescricao(produtoRequest.getDescricao());
        produto.setTipoProduto(produtoRequest.getTipoProduto());
        produto.setValorFornecedor(produtoRequest.getValorFornecedor());
        return produto;
    }
}
