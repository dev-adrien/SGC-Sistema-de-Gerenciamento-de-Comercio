package com.adrien.sgc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.dtos.ProdutoRequestDTO;
import com.adrien.sgc.dtos.ProdutoResponseDTO;
import com.adrien.sgc.entities.Categoria;
import com.adrien.sgc.entities.Produto;
import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.repositories.CategoriaRepository;
import com.adrien.sgc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome).stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));
        return new ProdutoResponseDTO(entity);
    }

    @Transactional
    public ProdutoResponseDTO inserir(ProdutoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + dto.getCategoriaId()));

        Produto entity = new Produto();
        copiarDtoParaEntidade(dto, entity, categoria);
        entity.setDescontinuado(false);

        entity = repository.save(entity);
        return new ProdutoResponseDTO(entity);
    }

    @Transactional
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + dto.getCategoriaId()));

        copiarDtoParaEntidade(dto, entity, categoria);

        entity = repository.save(entity);
        return new ProdutoResponseDTO(entity);
    }

    @Transactional
    public void descontinuar(Long id) {
        Produto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));
        entity.setDescontinuado(true);
        repository.save(entity);
    }

    private void copiarDtoParaEntidade(ProdutoRequestDTO dto, Produto entity, Categoria categoria) {
        entity.setCategoria(categoria);
        entity.setCodigoBarras(dto.getCodigoBarras());
        entity.setNome(dto.getNome());
        entity.setMarca(dto.getMarca());
        entity.setCor(dto.getCor());
        entity.setPrecoCusto(dto.getPrecoCusto());
        entity.setPrecoVenda(dto.getPrecoVenda());
        entity.setQtdEstoque(dto.getQtdEstoque());
        entity.setEstoqueMinimo(dto.getEstoqueMinimo());
    }
}