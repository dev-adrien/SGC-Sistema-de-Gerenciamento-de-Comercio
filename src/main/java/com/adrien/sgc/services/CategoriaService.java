package com.adrien.sgc.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.adrien.sgc.dtos.CategoriaRequestDTO;
import com.adrien.sgc.dtos.CategoriaResponseDTO;
import com.adrien.sgc.entities.Categoria;
import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<CategoriaResponseDTO> listarTodas() {
        return repository.findAll().stream()
                .map(CategoriaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + id));
        return new CategoriaResponseDTO(entity);
    }

    @Transactional
    public CategoriaResponseDTO inserir(CategoriaRequestDTO dto) {
        if (repository.existsByNome(dto.getNome())) {
            throw new IllegalArgumentException("Categoria já existente com este nome.");
        }
        Categoria entity = new Categoria();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity = repository.save(entity);
        return new CategoriaResponseDTO(entity);
    }

    @Transactional
    public CategoriaResponseDTO atualizar(Long id, CategoriaRequestDTO dto) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + id));

        if (!entity.getNome().equalsIgnoreCase(dto.getNome()) && repository.existsByNome(dto.getNome())) {
            throw new IllegalArgumentException("Categoria já existente com este nome.");
        }

        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity = repository.save(entity);
        return new CategoriaResponseDTO(entity);
    }
}