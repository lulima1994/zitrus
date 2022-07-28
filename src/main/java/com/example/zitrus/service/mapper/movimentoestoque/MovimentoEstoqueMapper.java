package com.example.zitrus.service.mapper.movimentoestoque;

import com.example.zitrus.domain.model.MovimentoEstoque;
import com.example.zitrus.domain.repository.ProdutoRepository;
import com.example.zitrus.dto.movimentoestoque.MovimentoEstoqueRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovimentoEstoqueMapper {
    private final ProdutoRepository produtoRepository;

    public MovimentoEstoque mapearRequest(MovimentoEstoqueRequest movimentoEstoqueRequest) {
        MovimentoEstoque movimentoEstoque = new MovimentoEstoque();
        movimentoEstoque.setId(movimentoEstoqueRequest.getId());
        movimentoEstoque.setProduto(produtoRepository.findByCodigo(movimentoEstoqueRequest.getCodigo()).orElseThrow());
        movimentoEstoque.setQuantidadeMovimentada(movimentoEstoqueRequest.getQuantidadeMovimentada());
        return movimentoEstoque;
    }
}
