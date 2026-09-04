package com.adrien.sgc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.LojaConfig;

public interface LojaConfigRepository extends JpaRepository<LojaConfig, Long> {
}