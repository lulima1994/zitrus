package com.example.zitrus.service;

import com.example.zitrus.domain.model.Produto;
import com.example.zitrus.domain.model.TipoProduto;
import com.example.zitrus.domain.repository.ProdutoRepository;
import com.example.zitrus.dto.produto.LucroProdutoResponse;
import com.example.zitrus.dto.produto.ProdutoRequest;
import com.example.zitrus.dto.produto.ProdutoResponse;
import com.example.zitrus.dto.produto.TipoProdutoResponse;
import com.example.zitrus.service.mapper.produto.LucroProdutoResponseMapper;
import com.example.zitrus.service.mapper.produto.ProdutoMapper;
import com.example.zitrus.service.mapper.produto.ProdutoResponseMapper;
import com.example.zitrus.service.mapper.produto.TipoProdutoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final ProdutoResponseMapper produtoResponseMapper;
    private final TipoProdutoResponseMapper tipoProdutoResponseMapper;
    private final LucroProdutoResponseMapper lucroProdutoResponseMapper;

    public ProdutoResponse adicionar(ProdutoRequest produtoRequest) {
        Produto produto = produtoMapper.mapearRequest(produtoRequest);
        produtoRepository.save(produto);
        return produtoResponseMapper.mapearResponse(produto);
    }

    public ProdutoResponse buscarPorCodigo(String codigo) {
        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(codigo);
        if (produtoOptional.isEmpty())
            throw new RuntimeException("produto " + codigo + " nao encontrado");
        return produtoResponseMapper.mapearResponse(produtoOptional.get());
    }

    public Page<ProdutoResponse> buscarPorPagina(Pageable pageable) {
        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return produtos.map(produtoResponseMapper::mapearResponse);
    }

    public Page<TipoProdutoResponse> buscarPorTipo(TipoProduto tipoProduto, Pageable pageable) {
        Page<Produto> produtos = produtoRepository.findAllByTipoProduto(tipoProduto, pageable);
        return produtos.map(tipoProdutoResponseMapper::mapearResponse);
    }

    public LucroProdutoResponse buscarLucro(String codigo) {
        Optional<Produto> produtoOptional = produtoRepository.findByCodigo(codigo);
        if (produtoOptional.isEmpty())
            throw new RuntimeException("produto " + codigo + " nao encontrado");
        return lucroProdutoResponseMapper.mapearResponse(produtoOptional.get());
    }

    public void deletarPorCodigo(String codigo) {
        produtoRepository.deleteByCodigo(codigo);
    }
}
