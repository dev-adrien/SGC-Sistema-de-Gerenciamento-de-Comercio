package com.adrien.sgc.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.adrien.sgc.entities.Venda;

public class VendaResponseDTO {

    private Long id;
    private Long usuarioId;
    private String usuarioNome;
    private Long clienteId;
    private String clienteNome;
    private String formaPagamento;
    private LocalDateTime dataVenda;
    private BigDecimal valorTotal;
    private String status;
    private String numeroRecibo;
    private String motivoEstorno;
    private List<ItemVendaResponseDTO> itens;

    public VendaResponseDTO() {
    }

    public VendaResponseDTO(Venda entity) {
        this.id = entity.getId();
        this.usuarioId = entity.getUsuario().getId();
        this.usuarioNome = entity.getUsuario().getNome();
        if (entity.getCliente() != null) {
            this.clienteId = entity.getCliente().getId();
            this.clienteNome = entity.getCliente().getNomeRazao();
        }
        this.formaPagamento = entity.getFormaPagamento().getNome();
        this.dataVenda = entity.getDataVenda();
        this.valorTotal = entity.getValorTotal();
        this.status = entity.getStatus();
        this.numeroRecibo = entity.getNumeroRecibo();
        this.motivoEstorno = entity.getMotivoEstorno();
        this.itens = entity.getItens().stream()
                .map(ItemVendaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public String getMotivoEstorno() {
        return motivoEstorno;
    }

    public void setMotivoEstorno(String motivoEstorno) {
        this.motivoEstorno = motivoEstorno;
    }

    public List<ItemVendaResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaResponseDTO> itens) {
        this.itens = itens;
    }
}