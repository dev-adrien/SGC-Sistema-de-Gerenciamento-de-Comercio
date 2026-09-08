package com.adrien.sgc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrien.sgc.dtos.LojaConfigRequestDTO;
import com.adrien.sgc.dtos.LojaConfigResponseDTO;
import com.adrien.sgc.services.LojaConfigService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/loja-config")
public class LojaConfigController {

    @Autowired
    private LojaConfigService service;

    @GetMapping
    public ResponseEntity<LojaConfigResponseDTO> obterConfiguracao() {
        LojaConfigResponseDTO dto = service.obterConfiguracao();
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping
    public ResponseEntity<LojaConfigResponseDTO> atualizarConfiguracao(@Valid @RequestBody LojaConfigRequestDTO dto) {
        LojaConfigResponseDTO updatedDto = service.atualizarConfiguracao(dto);
        return ResponseEntity.ok().body(updatedDto);
    }
}