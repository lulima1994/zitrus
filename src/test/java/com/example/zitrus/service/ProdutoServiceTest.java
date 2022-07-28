package com.example.zitrus.service;

import com.example.zitrus.domain.repository.ProdutoRepository;
import com.example.zitrus.service.mapper.produto.LucroProdutoResponseMapper;
import com.example.zitrus.service.mapper.produto.ProdutoMapper;
import com.example.zitrus.service.mapper.produto.ProdutoResponseMapper;
import com.example.zitrus.service.mapper.produto.TipoProdutoResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService service;
    @Mock
    private ProdutoRepository repository;
    @Mock
    private ProdutoMapper mapper;
    @Mock
    private ProdutoResponseMapper produtoResponseMapper;
    @Mock
    private TipoProdutoResponseMapper tipoProdutoResponseMapper;
    @Mock
    private LucroProdutoResponseMapper lucroProdutoResponseMapper;

    @Test
    void deveAdicionarUmProduto() {
        //arrange (given)
        //action (when)
        //assertion (then)
    }

    @Test
    void deveBuscarUmProdutoPorCodigo() {
    }

    @Test
    void deveBuscarUmaPaginaDeProdutos() {
    }

    @Test
    void deveBuscarUmaPaginaDeProdutosPorTipo() {
    }

    @Test
    void deveBuscarLucroDeUmProduto() {
    }

    @Test
    void deveDeletarUmProdutoPorCodigo() {
    }
}
