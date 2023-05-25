package com.comercio.relatorio.infra.persistence.service;

import com.comercio.relatorio.domain.entity.Relatorio;
import com.comercio.relatorio.infra.persistence.entity.RelatorioEntity;
import com.comercio.relatorio.infra.persistence.mapper.RelatorioPersistenceMapper;
import com.comercio.relatorio.infra.persistence.repository.RelatorioRepository;
import com.comercio.relatorio.usecase.persistence.RelatorioPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelatorioPersistenceServiceImpl implements RelatorioPersistenceService {

    private final RelatorioPersistenceMapper mapper;
    private final RelatorioRepository repository;

    public Relatorio save(Relatorio domain) {
        RelatorioEntity entity = repository.save(mapper.toEntity(domain));
        return mapper.toDomain(entity);
    }
}
