package com.adrien.sgc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrien.sgc.dtos.LogAuditoriaResponseDTO;
import com.adrien.sgc.services.LogAuditoriaService;

@RestController
@RequestMapping(value = "/api/auditoria")
public class LogAuditoriaController {

    @Autowired
    private LogAuditoriaService service;

    @GetMapping
    public ResponseEntity<List<LogAuditoriaResponseDTO>> listar(
            @RequestParam(value = "tipo", required = false) String tipo) {
        List<LogAuditoriaResponseDTO> list = (tipo != null && !tipo.isBlank())
                ? service.listarPorTipo(tipo)
                : service.listarTodos();
        return ResponseEntity.ok().body(list);
    }
}