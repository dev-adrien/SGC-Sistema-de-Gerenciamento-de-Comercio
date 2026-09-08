package com.adrien.sgc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adrien.sgc.dtos.FormaPagamentoResponseDTO;
import com.adrien.sgc.services.FormaPagamentoService;

@RestController
@RequestMapping(value = "/api/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService service;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoResponseDTO>> listarAtivas() {
        List<FormaPagamentoResponseDTO> list = service.listarAtivas();
        return ResponseEntity.ok().body(list);
    }
}