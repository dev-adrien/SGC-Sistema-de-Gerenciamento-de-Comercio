package com.adrien.sgc.dtos;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoRequestDTO {

    @NotNull(message = "A categoria é obrigatória.")
    private Long categoriaId;

    @Size(max = 50, message = "O código de barras deve ter no máximo 50 caracteres.")
    private String codigoBarras;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres.")
    private String nome;

    @Size(max = 100, message = "A marca deve ter no máximo 100 caracteres.")
    private String marca;

    @Size(max = 50, message = "A cor deve ter no máximo 50 caracteres.")
    private String cor;

    @NotNull(message = "O preço de custo é obrigatório.")
    @DecimalMin(value = "0.01", message = "O preço de custo deve ser maior que zero.")
    private BigDecimal precoCusto;

    @NotNull(message = "O preço de venda é obrigatório.")
    @DecimalMin(value = "0.01", message = "O preço de venda deve ser maior que zero.")
    private BigDecimal precoVenda;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    private Integer qtdEstoque;

    @NotNull(message = "O estoque mínimo é obrigatório.")
    private Integer estoqueMinimo;

    public ProdutoRequestDTO() {
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
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
}