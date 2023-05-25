package com.comercio.relatorio.infra.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRelatorioConsolidadoMessage {
    private LocalDate dataInico;
    private LocalDate dataFim;
}
