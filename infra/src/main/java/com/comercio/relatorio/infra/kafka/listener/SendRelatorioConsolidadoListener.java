package com.comercio.relatorio.infra.kafka.listener;

import com.comercio.relatorio.domain.entity.RelatorioConsolidado;
import com.comercio.relatorio.usecase.service.impl.CreateCsvServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendRelatorioConsolidadoListener {

    private final ObjectMapper mapper;
    private final CreateCsvServiceImpl createCsvServiceImpl;

    @KafkaListener(topics = "${kafka.topic.send-relatorio-consolidado}", groupId = "relatorio-group")
    public void listen(String message) {
        System.out.println("MENSAGEM RECEBIDA -> " + message);
        RelatorioConsolidado relatorioConsolidado;
        try {
            relatorioConsolidado = mapper.readValue(message, RelatorioConsolidado.class);
        } catch (Exception ex) {
            throw new KafkaException("Deu erro na conversao da mensagem do Kafka", ex);
        }

        createCsvServiceImpl.create(relatorioConsolidado);
    }
}
