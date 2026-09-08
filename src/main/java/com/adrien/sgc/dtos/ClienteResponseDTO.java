package com.adrien.sgc.dtos;

import com.adrien.sgc.entities.Cliente;

public class ClienteResponseDTO {

    private Long id;
    private String tipoPessoa;
    private String nomeRazao;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String endereco;
    private Boolean ativo;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(Cliente entity) {
        this.id = entity.getId();
        this.tipoPessoa = entity.getTipoPessoa();
        this.nomeRazao = entity.getNomeRazao();
        this.cpfCnpj = entity.getCpfCnpj();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.endereco = entity.getEndereco();
        this.ativo = entity.getAtivo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}