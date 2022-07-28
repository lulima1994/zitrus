package com.example.zitrus.rest;

import com.example.zitrus.dto.movimentoestoque.MovimentoEstoqueRequest;
import com.example.zitrus.dto.movimentoestoque.MovimentoEstoqueResponse;
import com.example.zitrus.service.MovimentoEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovimentoEstoqueController {
    private final MovimentoEstoqueService movimentoEstoqueService;

    @PostMapping("/comprar")
    public ResponseEntity<MovimentoEstoqueResponse> comprar(@RequestBody MovimentoEstoqueRequest movimentoEstoqueRequest) {
        if (movimentoEstoqueRequest.getId() != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        MovimentoEstoqueResponse movimentoEstoqueResponse = movimentoEstoqueService.comprar(movimentoEstoqueRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentoEstoqueResponse);
    }
}
