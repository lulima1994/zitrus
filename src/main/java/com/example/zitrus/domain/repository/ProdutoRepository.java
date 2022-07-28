package com.example.zitrus.domain.repository;

import com.example.zitrus.domain.model.Produto;
import com.example.zitrus.domain.model.TipoProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByCodigo(String codigo);

    @Transactional
    Optional<Produto> deleteByCodigo(String codigo);

    Page<Produto> findAllByTipoProduto(TipoProduto tipoProduto, Pageable pageable);
}
