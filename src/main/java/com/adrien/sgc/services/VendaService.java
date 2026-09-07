package com.adrien.sgc.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.dtos.EstornoRequestDTO;
import com.adrien.sgc.dtos.ItemVendaRequestDTO;
import com.adrien.sgc.dtos.VendaRequestDTO;
import com.adrien.sgc.dtos.VendaResponseDTO;
import com.adrien.sgc.entities.Cliente;
import com.adrien.sgc.entities.FormaPagamento;
import com.adrien.sgc.entities.ItemVenda;
import com.adrien.sgc.entities.Produto;
import com.adrien.sgc.entities.Usuario;
import com.adrien.sgc.entities.Venda;
import com.adrien.sgc.exceptions.ResourceNotFoundException;
import com.adrien.sgc.repositories.ClienteRepository;
import com.adrien.sgc.repositories.FormaPagamentoRepository;
import com.adrien.sgc.repositories.ProdutoRepository;
import com.adrien.sgc.repositories.UsuarioRepository;
import com.adrien.sgc.repositories.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<VendaResponseDTO> listarTodas() {
        return vendaRepository.findAll().stream()
                .map(VendaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VendaResponseDTO buscarPorId(Long id) {
        Venda entity = vendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada com o ID: " + id));
        return new VendaResponseDTO(entity);
    }

    @Transactional
    public VendaResponseDTO realizarVenda(VendaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + dto.getUsuarioId()));

        FormaPagamento formaPagamento = formaPagamentoRepository.findById(dto.getFormaPagamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Forma de pagamento não encontrada com o ID: " + dto.getFormaPagamentoId()));

        Cliente cliente = null;
        if (dto.getClienteId() != null) {
            cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + dto.getClienteId()));
        }

        Venda venda = new Venda();
        venda.setUsuario(usuario);
        venda.setCliente(cliente);
        venda.setFormaPagamento(formaPagamento);
        venda.setStatus("CONCLUIDA");
        venda.setNumeroRecibo("REC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        BigDecimal totalVenda = BigDecimal.ZERO;
        List<ItemVenda> itensVenda = new ArrayList<>();

        for (ItemVendaRequestDTO itemDto : dto.getItens()) {
            Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + itemDto.getProdutoId()));

            if (produto.getDescontinuado()) {
                throw new IllegalArgumentException("O produto " + produto.getNome() + " está descontinuado e não pode ser vendido.");
            }

            if (produto.getQtdEstoque() < itemDto.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome() + ". Disponível: " + produto.getQtdEstoque());
            }

            produto.setQtdEstoque(produto.getQtdEstoque() - itemDto.getQuantidade());
            produtoRepository.save(produto);

            ItemVenda item = new ItemVenda();
            item.setVenda(venda);
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setPrecoUnitario(produto.getPrecoVenda());

            BigDecimal subtotal = produto.getPrecoVenda().multiply(BigDecimal.valueOf(itemDto.getQuantidade()));
            item.setSubtotal(subtotal);

            totalVenda = totalVenda.add(subtotal);
            itensVenda.add(item);
        }

        venda.setValorTotal(totalVenda);
        venda.setItens(itensVenda);

        venda = vendaRepository.save(venda);
        return new VendaResponseDTO(venda);
    }

    @Transactional
    public VendaResponseDTO estornarVenda(Long id, EstornoRequestDTO dto) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada com o ID: " + id));

        if ("CANCELADA".equalsIgnoreCase(venda.getStatus())) {
            throw new IllegalArgumentException("Esta venda já foi estornada anteriormente.");
        }

        for (ItemVenda item : venda.getItens()) {
            Produto produto = item.getProduto();
            produto.setQtdEstoque(produto.getQtdEstoque() + item.getQuantidade());
            produtoRepository.save(produto);
        }

        venda.setStatus("CANCELADA");
        venda.setMotivoEstorno(dto.getMotivo());

        venda = vendaRepository.save(venda);
        return new VendaResponseDTO(venda);
    }
}