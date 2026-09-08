package com.adrien.sgc.dtos;

import com.adrien.sgc.entities.LojaConfig;

public class LojaConfigResponseDTO {

    private Long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;

    public LojaConfigResponseDTO() {
    }

    public LojaConfigResponseDTO(LojaConfig entity) {
        this.id = entity.getId();
        this.nomeFantasia = entity.getNomeFantasia();
        this.razaoSocial = entity.getRazaoSocial();
        this.cnpj = entity.getCnpj();
        this.endereco = entity.getEndereco();
        this.telefone = entity.getTelefone();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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