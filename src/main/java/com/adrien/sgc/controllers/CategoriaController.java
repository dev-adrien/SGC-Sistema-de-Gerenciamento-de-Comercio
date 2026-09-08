package com.adrien.sgc.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.adrien.sgc.dtos.CategoriaRequestDTO;
import com.adrien.sgc.dtos.CategoriaResponseDTO;
import com.adrien.sgc.services.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarTodas() {
        List<CategoriaResponseDTO> list = service.listarTodas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        CategoriaResponseDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> inserir(@Valid @RequestBody CategoriaRequestDTO dto) {
        CategoriaResponseDTO newDto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO dto) {
        CategoriaResponseDTO updatedDto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(updatedDto);
    }
}