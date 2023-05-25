package com.comercio.relatorio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lancamento {
    private UUID id;
    private BigDecimal valor;
    private TipoPagamentoEnum tipoPagamento;
    private LocalDateTime createdAt;
}
