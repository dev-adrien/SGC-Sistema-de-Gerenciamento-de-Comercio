package com.adrien.sgc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrien.sgc.dtos.RelatorioVendasResponseDTO;
import com.adrien.sgc.services.RelatorioService;

@RestController
@RequestMapping(value = "/api/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping(value = "/vendas")
    public ResponseEntity<RelatorioVendasResponseDTO> gerarRelatorioVendas() {
        RelatorioVendasResponseDTO relatorio = service.gerarRelatorioGeral();
        return ResponseEntity.ok().body(relatorio);
    }
}