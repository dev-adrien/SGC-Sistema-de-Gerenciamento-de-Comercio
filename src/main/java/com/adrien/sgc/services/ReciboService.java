package com.adrien.sgc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.dtos.ReciboResponseDTO;
import com.adrien.sgc.entities.LojaConfig;
import com.adrien.sgc.entities.Venda;
import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.repositories.LojaConfigRepository;
import com.adrien.sgc.repositories.VendaRepository;

@Service
public class ReciboService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private LojaConfigRepository lojaConfigRepository;

    @Transactional(readOnly = true)
    public ReciboResponseDTO gerarReciboVenda(Long vendaId) {
        Venda venda = vendaRepository.findById(vendaId)
                .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada com o ID: " + vendaId));

        LojaConfig loja = lojaConfigRepository.findAll().stream().findFirst().orElse(null);

        return new ReciboResponseDTO(venda, loja);
    }
}