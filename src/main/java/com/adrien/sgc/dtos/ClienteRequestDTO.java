package com.adrien.sgc.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {

    @NotBlank(message = "O tipo de pessoa é obrigatório (PF ou PJ).")
    @Pattern(regexp = "^(PF|PJ)$", message = "O tipo de pessoa deve ser 'PF' ou 'PJ'.")
    private String tipoPessoa;

    @NotBlank(message = "O nome/razão social é obrigatório.")
    @Size(max = 150, message = "O nome/razão social deve ter no máximo 150 caracteres.")
    private String nomeRazao;

    @NotBlank(message = "O CPF/CNPJ é obrigatório.")
    @Size(max = 18, message = "O CPF/CNPJ deve ter no máximo 18 caracteres.")
    private String cpfCnpj;

    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
    private String email;

    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres.")
    private String telefone;

    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
    private String endereco;

    public ClienteRequestDTO() {
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}