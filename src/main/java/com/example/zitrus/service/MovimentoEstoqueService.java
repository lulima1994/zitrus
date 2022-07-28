package com.example.zitrus.service;

import com.example.zitrus.domain.model.MovimentoEstoque;
import com.example.zitrus.domain.repository.MovimentoEstoqueRepository;
import com.example.zitrus.domain.repository.ProdutoRepository;
import com.example.zitrus.dto.movimentoestoque.MovimentoEstoqueRequest;
import com.example.zitrus.dto.movimentoestoque.MovimentoEstoqueResponse;
import com.example.zitrus.service.mapper.movimentoestoque.MovimentoEstoqueMapper;
import com.example.zitrus.service.mapper.movimentoestoque.MovimentoEstoqueResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class MovimentoEstoqueService {
    private final MovimentoEstoqueMapper movimentoEstoqueMapper;
    private final MovimentoEstoqueResponseMapper movimentoEstoqueResponseMapper;
    private final MovimentoEstoqueRepository movimentoEstoqueRepository;
    private final ProdutoRepository produtoRepository;

    @Transactional
    public MovimentoEstoqueResponse comprar(MovimentoEstoqueRequest movimentoEstoqueRequest) {
        var produto = produtoRepository.findByCodigo(movimentoEstoqueRequest.getCodigo()).orElseThrow();

        if (movimentoEstoqueRequest.getQuantidadeMovimentada() > produto.getQuantidadeEstoque())
            throw new RuntimeException("quantidade nao disponivel");

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - movimentoEstoqueRequest.getQuantidadeMovimentada());
        produto.setQuantidadeSaida(produto.getQuantidadeSaida() + movimentoEstoqueRequest.getQuantidadeMovimentada());
        var lucro = (produto.getValorFornecedor().multiply(produto.getTipoProduto().getValor()));
        var resultado = lucro.multiply(BigDecimal.valueOf(movimentoEstoqueRequest.getQuantidadeMovimentada()));
        produto.setLucro(produto.getLucro().add(resultado));
        produtoRepository.save(produto);

        MovimentoEstoque movimentoEstoque = movimentoEstoqueMapper.mapearRequest(movimentoEstoqueRequest);
        movimentoEstoqueRepository.save(movimentoEstoque);
        return movimentoEstoqueResponseMapper.mapearResponse(movimentoEstoque);
    }
}
