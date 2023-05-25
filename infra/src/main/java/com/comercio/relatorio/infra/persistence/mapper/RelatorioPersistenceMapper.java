package com.comercio.relatorio.infra.persistence.mapper;

import com.comercio.relatorio.domain.entity.Relatorio;
import com.comercio.relatorio.infra.persistence.entity.RelatorioEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface RelatorioPersistenceMapper {

    RelatorioEntity toEntity(final Relatorio domain);

    Relatorio toDomain(final RelatorioEntity entity);
}
