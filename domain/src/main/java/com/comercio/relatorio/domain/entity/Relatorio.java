package com.comercio.relatorio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {
    private String id;
    private String fileKey;
    private LocalDate dataInicioPesquisa;
    private LocalDate dataFimPesquisa;
    private BigDecimal saldo;
}
