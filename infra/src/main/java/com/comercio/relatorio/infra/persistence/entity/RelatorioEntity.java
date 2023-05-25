package com.comercio.relatorio.infra.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document(collection = "relatorios")
public class RelatorioEntity {
    @Id
    private String id;
    private String fileKey;
    private LocalDate dataInicioPesquisa;
    private LocalDate dataFimPesquisa;
    private BigDecimal saldo;
}
