package com.adrien.sgc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.dtos.ClienteRequestDTO;
import com.adrien.sgc.dtos.ClienteResponseDTO;
import com.adrien.sgc.entities.Cliente;
import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ClienteResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
        return new ClienteResponseDTO(entity);
    }

    @Transactional
    public ClienteResponseDTO inserir(ClienteRequestDTO dto) {
        if (repository.existsByCpfCnpj(dto.getCpfCnpj())) {
            throw new IllegalArgumentException("CPF/CNPJ já cadastrado para outro cliente.");
        }

        Cliente entity = new Cliente();
        copiarDtoParaEntidade(dto, entity);
        entity.setAtivo(true);

        entity = repository.save(entity);
        return new ClienteResponseDTO(entity);
    }

    @Transactional
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));

        if (!entity.getCpfCnpj().equals(dto.getCpfCnpj()) && repository.existsByCpfCnpj(dto.getCpfCnpj())) {
            throw new IllegalArgumentException("CPF/CNPJ já cadastrado para outro cliente.");
        }

        copiarDtoParaEntidade(dto, entity);

        entity = repository.save(entity);
        return new ClienteResponseDTO(entity);
    }

    private void copiarDtoParaEntidade(ClienteRequestDTO dto, Cliente entity) {
        entity.setTipoPessoa(dto.getTipoPessoa());
        entity.setNomeRazao(dto.getNomeRazao());
        entity.setCpfCnpj(dto.getCpfCnpj());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setEndereco(dto.getEndereco());
    }
}