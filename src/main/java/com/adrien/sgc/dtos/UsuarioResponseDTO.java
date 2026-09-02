package com.adrien.sgc.dtos;

import java.time.LocalDateTime;
import com.adrien.sgc.entities.Usuario;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String nivelAcesso;
    private Boolean status;
    private LocalDateTime dataCadastro;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.nivelAcesso = entity.getNivelAcesso();
        this.status = entity.getStatus();
        this.dataCadastro = entity.getDataCadastro();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
}