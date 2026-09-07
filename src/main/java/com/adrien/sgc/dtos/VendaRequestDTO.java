package com.adrien.sgc.dtos;

import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VendaRequestDTO {

    @NotNull(message = "O ID do operador/usuário é obrigatório.")
    private Long usuarioId;

    private Long clienteId;

    @NotNull(message = "A forma de pagamento é obrigatória.")
    private Long formaPagamentoId;

    @NotEmpty(message = "A venda deve conter pelo menos um item.")
    @Valid
    private List<ItemVendaRequestDTO> itens;

    public VendaRequestDTO() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(Long formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    public List<ItemVendaRequestDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaRequestDTO> itens) {
        this.itens = itens;
    }
}