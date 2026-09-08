package com.adrien.sgc.dtos;

import java.math.BigDecimal;

public class FaturamentoFormaPagamentoDTO {

    private String formaPagamento;
    private BigDecimal total;
    private Integer quantidadeVendas;

    public FaturamentoFormaPagamentoDTO() {
    }

    public FaturamentoFormaPagamentoDTO(String formaPagamento, BigDecimal total, Integer quantidadeVendas) {
        this.formaPagamento = formaPagamento;
        this.total = total;
        this.quantidadeVendas = quantidadeVendas;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(Integer quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }
}