package com.comercio.relatorio.usecase.service.impl;

import com.comercio.relatorio.domain.entity.Lancamento;
import com.comercio.relatorio.domain.entity.Relatorio;
import com.comercio.relatorio.domain.entity.RelatorioConsolidado;
import com.comercio.relatorio.usecase.persistence.RelatorioPersistenceService;
import com.comercio.relatorio.usecase.service.CreateCsvService;
import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateCsvServiceImpl implements CreateCsvService {

    private final S3Client s3Client;
    private final RelatorioPersistenceService relatorioPersistenceService;

    public void create(RelatorioConsolidado response) {
        if (response.getLancamentoList().isEmpty()) throw new RuntimeException("Relatorio vazio = " + response);
        LocalDate localDate = response.getLancamentoList().get(0).getCreatedAt().toLocalDate();
        String fileKey = generateAndUploadCsv(response);
        Relatorio relatorio = new Relatorio(null, fileKey, localDate, localDate, response.getSaldoConsolidado());
        relatorioPersistenceService.save(relatorio);
    }

    public String generateAndUploadCsv(RelatorioConsolidado relatorioConsolidado) {
        try {
            Writer writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer);

            String[] header = {"Data", "TipoPagamento", "Valor"};
            csvWriter.writeNext(header);

            for (Lancamento lancamento : relatorioConsolidado.getLancamentoList()) {
                String[] data = {lancamento.getCreatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), lancamento.getTipoPagamento().toString(), lancamento.getValor().toString()};
                csvWriter.writeNext(data);
            }

            String[] rodape = {"Saldo", "", relatorioConsolidado.getSaldoConsolidado().toString()};
            csvWriter.writeNext(rodape);

            try {
                csvWriter.close();
            } catch (Exception ex) {
                System.out.println("DEU ERRROOOOOOOOOOOOO");
            }

            // Enviar arquivo para o S3
            byte[] content = writer.toString().getBytes();
            String data = LocalDate.now().minusDays(1).toString();
            String uuid = UUID.randomUUID().toString();
            String fileName = data + "_" + uuid + ".csv";

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket("comercio-relatorio")
                    .key(fileName)
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(content));

            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro no upload");
        }
    }
}
