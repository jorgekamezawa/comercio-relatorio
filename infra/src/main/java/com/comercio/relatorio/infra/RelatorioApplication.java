package com.comercio.relatorio.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@ComponentScan("com.comercio.relatorio.*")
@SpringBootApplication
public class RelatorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelatorioApplication.class, args);
	}

}
