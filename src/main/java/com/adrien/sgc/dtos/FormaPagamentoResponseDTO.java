package com.adrien.sgc.dtos;

import com.adrien.sgc.entities.FormaPagamento;

public class FormaPagamentoResponseDTO {

    private Long id;
    private String nome;
    private Boolean ativo;

    public FormaPagamentoResponseDTO() {
    }

    public FormaPagamentoResponseDTO(FormaPagamento entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.ativo = entity.getAtivo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}