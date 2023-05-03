package br.com.currencyconverter.adapter.common.mapper;

import br.com.currencyconverter.adapter.in.dto.ConversaoDTO;
import br.com.currencyconverter.adapter.in.dto.ConversaoMassaDTO;
import br.com.currencyconverter.core.dominio.Conversao;
import br.com.currencyconverter.core.dominio.ConversaoMassa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConversaoMapper {

    @Mapping(source = "moedaOrigem", target = "moedaOrigem")
    @Mapping(source = "moedaDestino", target = "moedaDestino")
    @Mapping(source = "valor", target = "valorOrigem")
    Conversao dtoToDomain(ConversaoDTO conversaoDTO);

    @Mapping(source = "moedaOrigem", target = "moedaOrigem")
    @Mapping(source = "moedaDestino", target = "moedaDestino")
    @Mapping(source = "valorOrigem", target = "valor")
    ConversaoDTO domainToDto(Conversao conversao);

    @Mapping(source = "conversoes", target = "conversoes")
    ConversaoMassa dtoToDomain(ConversaoMassaDTO conversaoMassaDTO);

    @Mapping(source = "conversoes", target = "conversoes")
    ConversaoMassaDTO domainToDto(ConversaoMassa conversaoMassa);
}

