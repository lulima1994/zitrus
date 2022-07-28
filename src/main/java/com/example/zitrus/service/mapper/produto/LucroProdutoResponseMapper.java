package com.example.zitrus.service.mapper.produto;

import com.example.zitrus.domain.model.Produto;
import com.example.zitrus.dto.produto.LucroProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LucroProdutoResponseMapper {
    private final ProdutoResponseMapper produtoResponseMapper;

    public LucroProdutoResponse mapearResponse(Produto produto) {
        LucroProdutoResponse lucroProdutoResponse = new LucroProdutoResponse();
        lucroProdutoResponse.setProdutoResponse(produtoResponseMapper.mapearResponse(produto));
        lucroProdutoResponse.setQuantidadeSaida(produto.getQuantidadeSaida());
        lucroProdutoResponse.setLucro(produto.getLucro());
        return lucroProdutoResponse;
    }
}
