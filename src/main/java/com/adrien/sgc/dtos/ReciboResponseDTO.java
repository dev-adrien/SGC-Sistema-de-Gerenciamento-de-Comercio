package com.adrien.sgc.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.adrien.sgc.entities.LojaConfig;
import com.adrien.sgc.entities.Venda;

public class ReciboResponseDTO {

    private String numeroRecibo;
    private LocalDateTime dataEmissao;
    private String lojaNomeFantasia;
    private String lojaCnpj;
    private String lojaEndereco;
    private String lojaTelefone;
    private String operador;
    private String clienteNome;
    private String clienteCpfCnpj;
    private String formaPagamento;
    private BigDecimal valorTotal;
    private List<ItemVendaResponseDTO> itens;

    public ReciboResponseDTO() {
    }

    public ReciboResponseDTO(Venda venda, LojaConfig loja) {
        this.numeroRecibo = venda.getNumeroRecibo();
        this.dataEmissao = venda.getDataVenda();
        if (loja != null) {
            this.lojaNomeFantasia = loja.getNomeFantasia();
            this.lojaCnpj = loja.getCnpj();
            this.lojaEndereco = loja.getEndereco();
            this.lojaTelefone = loja.getTelefone();
        }
        this.operador = venda.getUsuario().getNome();
        if (venda.getCliente() != null) {
            this.clienteNome = venda.getCliente().getNomeRazao();
            this.clienteCpfCnpj = venda.getCliente().getCpfCnpj();
        } else {
            this.clienteNome = "CONSUMIDOR FINAL";
            this.clienteCpfCnpj = "NAO INFORMADO";
        }
        this.formaPagamento = venda.getFormaPagamento().getNome();
        this.valorTotal = venda.getValorTotal();
        this.itens = venda.getItens().stream()
                .map(ItemVendaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getLojaNomeFantasia() {
        return lojaNomeFantasia;
    }

    public void setLojaNomeFantasia(String lojaNomeFantasia) {
        this.lojaNomeFantasia = lojaNomeFantasia;
    }

    public String getLojaCnpj() {
        return lojaCnpj;
    }

    public void setLojaCnpj(String lojaCnpj) {
        this.lojaCnpj = lojaCnpj;
    }

    public String getLojaEndereco() {
        return lojaEndereco;
    }

    public void setLojaEndereco(String lojaEndereco) {
        this.lojaEndereco = lojaEndereco;
    }

    public String getLojaTelefone() {
        return lojaTelefone;
    }

    public void setLojaTelefone(String lojaTelefone) {
        this.lojaTelefone = lojaTelefone;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCpfCnpj() {
        return clienteCpfCnpj;
    }

    public void setClienteCpfCnpj(String clienteCpfCnpj) {
        this.clienteCpfCnpj = clienteCpfCnpj;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVendaResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaResponseDTO> itens) {
        this.itens = itens;
    }
}