package com.comercio.relatorio.usecase.persistence;

import com.comercio.relatorio.domain.entity.Relatorio;

public interface RelatorioPersistenceService {
    Relatorio save(Relatorio domain);
}
