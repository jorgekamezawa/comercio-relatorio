package com.comercio.relatorio.infra.rest.controller.impl;

import com.comercio.relatorio.infra.kafka.message.CreateRelatorioConsolidadoMessage;
import com.comercio.relatorio.infra.kafka.producer.CreateRelatorioProducer;
import com.comercio.relatorio.infra.rest.controller.RelatorioController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorio")
@RequiredArgsConstructor
public class RelatorioControllerImpl implements RelatorioController {

    private final CreateRelatorioProducer createRelatorioProducer;

    @Override
    public void enviar(CreateRelatorioConsolidadoMessage form) {
        createRelatorioProducer.sendRelatorio(form);
    }
}
