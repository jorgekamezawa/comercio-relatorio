package com.comercio.relatorio.infra.kafka.producer;

import com.comercio.relatorio.infra.kafka.message.CreateRelatorioConsolidadoMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRelatorioProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendRelatorio(CreateRelatorioConsolidadoMessage form) {
        String message;
        try {
            message = objectMapper.writeValueAsString(form);
            System.out.println("ENVIANDO MENSAGEM -> " + message);
        } catch (Exception exception) {
            System.out.println("DEU ERROOOO");
            throw new RuntimeException("Deu erro no mapper", exception);
        }
        System.out.println("Sending message to send_relatorio: " + message);
        kafkaTemplate.send("create_relatorio_consolidado_lancamentos", message);
    }
}
