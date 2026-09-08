package com.adrien.sgc.dtos;

import java.math.BigDecimal;
import com.adrien.sgc.entities.Produto;

public class ProdutoResponseDTO {

    private Long id;
    private CategoriaResponseDTO categoria;
    private String codigoBarras;
    private String nome;
    private String marca;
    private String cor;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Integer qtdEstoque;
    private Integer estoqueMinimo;
    private Boolean descontinuado;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO(Produto entity) {
        this.id = entity.getId();
        this.codigoBarras = entity.getCodigoBarras();
        this.nome = entity.getNome();
        this.marca = entity.getMarca();
        this.cor = entity.getCor();
        this.precoCusto = entity.getPrecoCusto();
        this.precoVenda = entity.getPrecoVenda();
        this.qtdEstoque = entity.getQtdEstoque();
        this.estoqueMinimo = entity.getEstoqueMinimo();
        this.descontinuado = entity.getDescontinuado();
        if (entity.getCategoria() != null) {
            this.categoria = new CategoriaResponseDTO(entity.getCategoria());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Boolean getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Boolean descontinuado) {
        this.descontinuado = descontinuado;
    }
}