package br.com.currencyconverter.adapter.common.mapper;

import br.com.currencyconverter.adapter.in.dto.MoedaDto;
import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity;
import br.com.currencyconverter.core.dominio.Moeda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MoedaMapper {

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "simbolo", target = "simbolo")
    MoedaDto domainToDto(Moeda moeda);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "simbolo", target = "simbolo")
    MoedaEntity domainToEntity(Moeda moeda);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "simbolo", target = "simbolo")
    Moeda entityToDomain(MoedaEntity moedaEntity);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "simbolo", target = "simbolo")
    Moeda dtoToDomain(MoedaDto moedaDto);
}
