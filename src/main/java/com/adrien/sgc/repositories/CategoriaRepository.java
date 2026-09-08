package com.adrien.sgc.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
    boolean existsByNome(String nome);
}