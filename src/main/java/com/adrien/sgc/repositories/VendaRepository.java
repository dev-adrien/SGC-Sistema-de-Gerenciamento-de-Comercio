package com.adrien.sgc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}