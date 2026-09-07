package com.adrien.sgc.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstornoRequestDTO {

    @NotBlank(message = "O motivo do estorno é obrigatório.")
    @Size(max = 255, message = "O motivo do estorno deve ter no máximo 255 caracteres.")
    private String motivo;

    public EstornoRequestDTO() {
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}