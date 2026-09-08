package com.adrien.sgc.dtos;

import jakarta.validation.constraints.NotBlank;

public class NivelAcessoRequestDTO {

    @NotBlank(message = "O nível de acesso é obrigatório.")
    private String nivelAcesso;

    public NivelAcessoRequestDTO() {
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}