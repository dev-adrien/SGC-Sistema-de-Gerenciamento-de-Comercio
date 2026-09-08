package com.adrien.sgc.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LojaConfigRequestDTO {

    @NotBlank(message = "O nome fantasia é obrigatório.")
    @Size(max = 150, message = "O nome fantasia deve ter no máximo 150 caracteres.")
    private String nomeFantasia;

    @Size(max = 150, message = "A razão social deve ter no máximo 150 caracteres.")
    private String razaoSocial;

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Size(max = 18, message = "O CNPJ deve ter no máximo 18 caracteres.")
    private String cnpj;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
    private String endereco;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres.")
    private String telefone;

    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
    private String email;

    public LojaConfigRequestDTO() {
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}