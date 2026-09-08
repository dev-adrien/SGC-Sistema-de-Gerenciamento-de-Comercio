package com.adrien.sgc.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RedefinirSenhaRequestDTO {

    @NotBlank(message = "A nova senha é obrigatória.")
    @Size(min = 6, message = "A nova senha deve ter no mínimo 6 caracteres.")
    private String novaSenha;

    public RedefinirSenhaRequestDTO() {
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}