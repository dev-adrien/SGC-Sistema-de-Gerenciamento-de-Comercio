package com.adrien.sgc.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.adrien.sgc.dtos.FormaPagamentoResponseDTO;
import com.adrien.sgc.repositories.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;

    @Transactional(readOnly = true)
    public List<FormaPagamentoResponseDTO> listarAtivas() {
        return repository.findByAtivoTrue().stream()
                .map(FormaPagamentoResponseDTO::new)
                .collect(Collectors.toList());
    }
}