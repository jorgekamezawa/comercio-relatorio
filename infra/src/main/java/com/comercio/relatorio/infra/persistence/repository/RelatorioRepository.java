package com.comercio.relatorio.infra.persistence.repository;

import com.comercio.relatorio.infra.persistence.entity.RelatorioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends MongoRepository<RelatorioEntity, String> {
}
