package com.adrien.sgc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.dtos.LojaConfigRequestDTO;
import com.adrien.sgc.dtos.LojaConfigResponseDTO;
import com.adrien.sgc.entities.LojaConfig;
import com.adrien.sgc.repositories.LojaConfigRepository;

@Service
public class LojaConfigService {

    @Autowired
    private LojaConfigRepository repository;

    @Transactional(readOnly = true)
    public LojaConfigResponseDTO obterConfiguracao() {
        LojaConfig config = repository.findAll().stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Configuração da loja não encontrada."));
        return new LojaConfigResponseDTO(config);
    }

    @Transactional
    public LojaConfigResponseDTO atualizarConfiguracao(LojaConfigRequestDTO dto) {
        LojaConfig config = repository.findAll().stream().findFirst()
                .orElseGet(LojaConfig::new);

        config.setNomeFantasia(dto.getNomeFantasia());
        config.setRazaoSocial(dto.getRazaoSocial());
        config.setCnpj(dto.getCnpj());
        config.setEndereco(dto.getEndereco());
        config.setTelefone(dto.getTelefone());
        config.setEmail(dto.getEmail());

        config = repository.save(config);
        return new LojaConfigResponseDTO(config);
    }
}