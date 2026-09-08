package com.adrien.sgc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.LogAuditoria;

public interface LogAuditoriaRepository extends JpaRepository<LogAuditoria, Long> {
    List<LogAuditoria> findByTipoEventoOrderByDataHoraDesc(String tipoEvento);
    List<LogAuditoria> findAllByOrderByDataHoraDesc();
}