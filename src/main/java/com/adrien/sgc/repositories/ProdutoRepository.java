package com.adrien.sgc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.adrien.sgc.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM Produto p JOIN FETCH p.categoria WHERE p.qtdEstoque <= p.estoqueMinimo AND p.descontinuado = false")
    List<Produto> buscarAbaixoEstoqueMinimo();
}