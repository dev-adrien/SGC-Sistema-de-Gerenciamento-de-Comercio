package com.adrien.sgc.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adrien.sgc.dtos.ProdutoRequestDTO;
import com.adrien.sgc.dtos.ProdutoResponseDTO;
import com.adrien.sgc.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        List<ProdutoResponseDTO> list = service.listarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/busca")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorNome(
            @RequestParam(value = "nome", defaultValue = "") String nome) {
        List<ProdutoResponseDTO> list = nome.isBlank()
                ? service.listarTodos()
                : service.buscarPorNome(nome);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        ProdutoResponseDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> inserir(@Valid @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO newDto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO updatedDto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(updatedDto);
    }

    @PatchMapping(value = "/{id}/descontinuar")
    public ResponseEntity<Void> descontinuar(@PathVariable Long id) {
        service.descontinuar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/alertas/estoque-baixo")
    public ResponseEntity<List<ProdutoResponseDTO>> listarAbaixoEstoqueMinimo() {
        List<ProdutoResponseDTO> list = service.listarAbaixoEstoqueMinimo();
        return ResponseEntity.ok().body(list);
    }
}