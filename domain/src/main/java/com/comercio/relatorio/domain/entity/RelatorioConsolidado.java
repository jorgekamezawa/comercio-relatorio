package com.comercio.relatorio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioConsolidado {
    private List<Lancamento> lancamentoList;
    private BigDecimal saldoConsolidado;
}
