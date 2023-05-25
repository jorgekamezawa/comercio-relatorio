package com.comercio.relatorio.infra.rest.controller;

import com.comercio.relatorio.infra.kafka.message.CreateRelatorioConsolidadoMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface RelatorioController {

    @PostMapping("/producer")
    @ResponseStatus(HttpStatus.OK)
    void enviar(@RequestBody final CreateRelatorioConsolidadoMessage form);
}
