package com.adrien.sgc.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrien.sgc.dtos.FaturamentoFormaPagamentoDTO;
import com.adrien.sgc.dtos.RelatorioVendasResponseDTO;
import com.adrien.sgc.entities.Venda;
import com.adrien.sgc.repositories.VendaRepository;

@Service
public class RelatorioService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional(readOnly = true)
    public RelatorioVendasResponseDTO gerarRelatorioGeral() {
        List<Venda> vendas = vendaRepository.findAll();

        List<Venda> concluidas = vendas.stream()
                .filter(v -> "CONCLUIDA".equalsIgnoreCase(v.getStatus()))
                .collect(Collectors.toList());

        List<Venda> canceladas = vendas.stream()
                .filter(v -> "CANCELADA".equalsIgnoreCase(v.getStatus()))
                .collect(Collectors.toList());

        BigDecimal totalFaturado = concluidas.stream()
                .map(Venda::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalEstornado = canceladas.stream()
                .map(Venda::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int totalConcluidas = concluidas.size();
        BigDecimal ticketMedio = totalConcluidas > 0
                ? totalFaturado.divide(BigDecimal.valueOf(totalConcluidas), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        Map<String, List<Venda>> vendasPorForma = concluidas.stream()
                .collect(Collectors.groupingBy(v -> v.getFormaPagamento().getNome()));

        List<FaturamentoFormaPagamentoDTO> faturamentoPorForma = new ArrayList<>();
        vendasPorForma.forEach((forma, lista) -> {
            BigDecimal subtotalForma = lista.stream()
                    .map(Venda::getValorTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            faturamentoPorForma.add(new FaturamentoFormaPagamentoDTO(forma, subtotalForma, lista.size()));
        });

        RelatorioVendasResponseDTO relatorio = new RelatorioVendasResponseDTO();
        relatorio.setTotalFaturado(totalFaturado);
        relatorio.setTotalVendasConcluidas(totalConcluidas);
        relatorio.setTicketMedio(ticketMedio);
        relatorio.setTotalVendasCanceladas(canceladas.size());
        relatorio.setTotalEstornado(totalEstornado);
        relatorio.setFaturamentoPorFormaPagamento(faturamentoPorForma);

        return relatorio;
    }
}