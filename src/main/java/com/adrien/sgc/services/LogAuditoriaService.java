package com.adrien.sgc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.dtos.LogAuditoriaResponseDTO;
import com.adrien.sgc.entities.LogAuditoria;
import com.adrien.sgc.entities.Usuario;
import com.adrien.sgc.repositories.LogAuditoriaRepository;

@Service
public class LogAuditoriaService {

    @Autowired
    private LogAuditoriaRepository repository;

    @Transactional
    public void registrarLog(Usuario usuario, String acao, String tipoEvento, String ip) {
        LogAuditoria log = new LogAuditoria(usuario, acao, tipoEvento, ip != null ? ip : "127.0.0.1");
        repository.save(log);
    }

    @Transactional(readOnly = true)
    public List<LogAuditoriaResponseDTO> listarTodos() {
        return repository.findAllByOrderByDataHoraDesc().stream()
                .map(LogAuditoriaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<LogAuditoriaResponseDTO> listarPorTipo(String tipoEvento) {
        return repository.findByTipoEventoOrderByDataHoraDesc(tipoEvento).stream()
                .map(LogAuditoriaResponseDTO::new)
                .collect(Collectors.toList());
    }
}