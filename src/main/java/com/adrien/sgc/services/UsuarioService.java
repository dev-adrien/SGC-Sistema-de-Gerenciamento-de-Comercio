package com.adrien.sgc.services;

import java.util.List;
import java.util.stream.Collectors;

import com.adrien.sgc.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.entities.Usuario;
import com.adrien.sgc.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        return new UsuarioResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO inserir(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado no sistema.");
        }

        Usuario entity = new Usuario();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());

        entity.setSenhaHash(dto.getSenha());
        entity.setNivelAcesso(dto.getNivelAcesso());
        entity.setStatus(true);

        entity = usuarioRepository.save(entity);
        return new UsuarioResponseDTO(entity);
    }

    @Transactional
    public void inativar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuario.setStatus(false);
        usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public LoginResponseDTO autenticar(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Credenciais inválidas."));

        if (!usuario.getStatus()) {
            throw new IllegalArgumentException("Usuário inativo no sistema.");
        }

        if (!usuario.getSenhaHash().equals(dto.getSenha())) {
            throw new IllegalArgumentException("Credenciais inválidas.");
        }

        String token = java.util.UUID.randomUUID().toString();
        return new LoginResponseDTO(token, "Bearer", new UsuarioResponseDTO(usuario));
    }

    @Transactional
    public void redefinirSenha(Long id, RedefinirSenhaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuario.setSenhaHash(dto.getNovaSenha());
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterarNivelAcesso(Long id, NivelAcessoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuario.setNivelAcesso(dto.getNivelAcesso());
        usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public void solicitarRecuperacaoSenha(RecuperarSenhaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("E-mail não cadastrado no sistema."));
    }
}