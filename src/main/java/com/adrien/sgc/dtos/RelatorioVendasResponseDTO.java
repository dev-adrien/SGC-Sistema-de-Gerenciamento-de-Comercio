package com.adrien.sgc.dtos;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioVendasResponseDTO {

    private BigDecimal totalFaturado;
    private Integer totalVendasConcluidas;
    private BigDecimal ticketMedio;
    private Integer totalVendasCanceladas;
    private BigDecimal totalEstornado;
    private List<FaturamentoFormaPagamentoDTO> faturamentoPorFormaPagamento;

    public RelatorioVendasResponseDTO() {
    }

    public BigDecimal getTotalFaturado() {
        return totalFaturado;
    }

    public void setTotalFaturado(BigDecimal totalFaturado) {
        this.totalFaturado = totalFaturado;
    }

    public Integer getTotalVendasConcluidas() {
        return totalVendasConcluidas;
    }

    public void setTotalVendasConcluidas(Integer totalVendasConcluidas) {
        this.totalVendasConcluidas = totalVendasConcluidas;
    }

    public BigDecimal getTicketMedio() {
        return ticketMedio;
    }

    public void setTicketMedio(BigDecimal ticketMedio) {
        this.ticketMedio = ticketMedio;
    }

    public Integer getTotalVendasCanceladas() {
        return totalVendasCanceladas;
    }

    public void setTotalVendasCanceladas(Integer totalVendasCanceladas) {
        this.totalVendasCanceladas = totalVendasCanceladas;
    }

    public BigDecimal getTotalEstornado() {
        return totalEstornado;
    }

    public void setTotalEstornado(BigDecimal totalEstornado) {
        this.totalEstornado = totalEstornado;
    }

    public List<FaturamentoFormaPagamentoDTO> getFaturamentoPorFormaPagamento() {
        return faturamentoPorFormaPagamento;
    }

    public void setFaturamentoPorFormaPagamento(List<FaturamentoFormaPagamentoDTO> faturamentoPorFormaPagamento) {
        this.faturamentoPorFormaPagamento = faturamentoPorFormaPagamento;
    }
}