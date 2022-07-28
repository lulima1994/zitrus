package com.example.zitrus.rest;

import com.example.zitrus.domain.model.TipoProduto;
import com.example.zitrus.dto.produto.LucroProdutoResponse;
import com.example.zitrus.dto.produto.ProdutoRequest;
import com.example.zitrus.dto.produto.ProdutoResponse;
import com.example.zitrus.dto.produto.TipoProdutoResponse;
import com.example.zitrus.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping("/produto")
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.adicionar(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @PutMapping("/produto")
    public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.adicionar(produtoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @GetMapping("/produto/{codigo}")
    public ResponseEntity<ProdutoResponse> buscarPorCodigo(@PathVariable String codigo) {
        ProdutoResponse produtoResponse = produtoService.buscarPorCodigo(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @GetMapping("/produto")
    public ResponseEntity<Page<ProdutoResponse>> buscarPorPagina(Pageable pageable) {
        Page<ProdutoResponse> produtoResponses = produtoService.buscarPorPagina(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponses);
    }

    @GetMapping("/produto/tipo/{tipoProduto}")
    public ResponseEntity<Page<TipoProdutoResponse>> buscarPorTipo(@PathVariable("tipoProduto") TipoProduto tipoProduto, Pageable pageable) {
        Page<TipoProdutoResponse> tipoProdutoResponses = produtoService.buscarPorTipo(tipoProduto, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(tipoProdutoResponses);
    }

    @GetMapping("/produto/lucro/{codigo}")
    public ResponseEntity<LucroProdutoResponse> buscarLucro(@PathVariable String codigo) {
        LucroProdutoResponse lucroProdutoResponse = produtoService.buscarLucro(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(lucroProdutoResponse);
    }

    @DeleteMapping("/produto/{codigo}")
    public ResponseEntity<String> deletarPorCodigo(@PathVariable String codigo) {
        produtoService.deletarPorCodigo(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("produto " + codigo + " deletado");
    }
}
