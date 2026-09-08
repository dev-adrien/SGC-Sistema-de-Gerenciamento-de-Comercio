package com.adrien.sgc.dtos;

import java.math.BigDecimal;
import com.adrien.sgc.entities.ItemVenda;

public class ItemVendaResponseDTO {

    private Long id;
    private Long produtoId;
    private String produtoNome;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    public ItemVendaResponseDTO() {
    }

    public ItemVendaResponseDTO(ItemVenda entity) {
        this.id = entity.getId();
        this.produtoId = entity.getProduto().getId();
        this.produtoNome = entity.getProduto().getNome();
        this.quantidade = entity.getQuantidade();
        this.precoUnitario = entity.getPrecoUnitario();
        this.subtotal = entity.getSubtotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}