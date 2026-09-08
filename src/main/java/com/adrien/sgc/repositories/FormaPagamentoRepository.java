package com.adrien.sgc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    List<FormaPagamento> findByAtivoTrue();
}