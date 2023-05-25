package com.comercio.relatorio.usecase.service.impl;

import com.comercio.relatorio.domain.entity.Relatorio;
import com.comercio.relatorio.domain.entity.RelatorioConsolidado;
import com.comercio.relatorio.usecase.persistence.RelatorioPersistenceService;
import com.comercio.relatorio.usecase.service.CreateCsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateCsvServiceImpl implements CreateCsvService {

    private final RelatorioPersistenceService relatorioPersistenceService;

    public void create(RelatorioConsolidado response) {
        if (response.getLancamentoList().isEmpty()) throw new RuntimeException("Relatorio vazio = " + response);
        LocalDate localDate = response.getLancamentoList().get(0).getCreatedAt().toLocalDate();
        Relatorio relatorio = new Relatorio(null, UUID.randomUUID().toString(), localDate, localDate, response.getSaldoConsolidado());
        relatorioPersistenceService.save(relatorio);
    }
}
