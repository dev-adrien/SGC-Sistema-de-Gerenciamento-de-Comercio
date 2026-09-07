package com.adrien.sgc.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adrien.sgc.dtos.EstornoRequestDTO;
import com.adrien.sgc.dtos.VendaRequestDTO;
import com.adrien.sgc.dtos.VendaResponseDTO;
import com.adrien.sgc.services.VendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> listarTodas() {
        List<VendaResponseDTO> list = service.listarTodas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaResponseDTO> buscarPorId(@PathVariable Long id) {
        VendaResponseDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<VendaResponseDTO> realizarVenda(@Valid @RequestBody VendaRequestDTO dto) {
        VendaResponseDTO newDto = service.realizarVenda(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PatchMapping(value = "/{id}/estorno")
    public ResponseEntity<VendaResponseDTO> estornarVenda(
            @PathVariable Long id,
            @Valid @RequestBody EstornoRequestDTO dto) {
        VendaResponseDTO response = service.estornarVenda(id, dto);
        return ResponseEntity.ok().body(response);
    }
}