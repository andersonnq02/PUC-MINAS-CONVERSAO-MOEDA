package br.com.currencyconverter.adapter.common.mapper;

import br.com.currencyconverter.adapter.in.dto.ConversaoDTO;
import br.com.currencyconverter.adapter.in.dto.ConversaoDTO.ConversaoDTOBuilder;
import br.com.currencyconverter.adapter.in.dto.ConversaoMassaDTO;
import br.com.currencyconverter.adapter.in.dto.ConversaoMassaDTO.ConversaoMassaDTOBuilder;
import br.com.currencyconverter.core.dominio.Conversao;
import br.com.currencyconverter.core.dominio.Conversao.ConversaoBuilder;
import br.com.currencyconverter.core.dominio.ConversaoMassa;
import br.com.currencyconverter.core.dominio.ConversaoMassa.ConversaoMassaBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-01T23:56:58-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ConversaoMapperImpl implements ConversaoMapper {

    @Override
    public Conversao dtoToDomain(ConversaoDTO conversaoDTO) {
        if ( conversaoDTO == null ) {
            return null;
        }

        ConversaoBuilder conversao = Conversao.builder();

        conversao.moedaOrigem( conversaoDTO.getMoedaOrigem() );
        conversao.moedaDestino( conversaoDTO.getMoedaDestino() );
        conversao.valorOrigem( conversaoDTO.getValor() );

        return conversao.build();
    }

    @Override
    public ConversaoDTO domainToDto(Conversao conversao) {
        if ( conversao == null ) {
            return null;
        }

        ConversaoDTOBuilder conversaoDTO = ConversaoDTO.builder();

        conversaoDTO.moedaOrigem( conversao.getMoedaOrigem() );
        conversaoDTO.moedaDestino( conversao.getMoedaDestino() );
        conversaoDTO.valor( conversao.getValorOrigem() );

        return conversaoDTO.build();
    }

    @Override
    public ConversaoMassa dtoToDomain(ConversaoMassaDTO conversaoMassaDTO) {
        if ( conversaoMassaDTO == null ) {
            return null;
        }

        ConversaoMassaBuilder conversaoMassa = ConversaoMassa.builder();

        conversaoMassa.conversoes( conversaoDTOListToConversaoList( conversaoMassaDTO.getConversoes() ) );

        return conversaoMassa.build();
    }

    @Override
    public ConversaoMassaDTO domainToDto(ConversaoMassa conversaoMassa) {
        if ( conversaoMassa == null ) {
            return null;
        }

        ConversaoMassaDTOBuilder conversaoMassaDTO = ConversaoMassaDTO.builder();

        conversaoMassaDTO.conversoes( conversaoListToConversaoDTOList( conversaoMassa.getConversoes() ) );

        return conversaoMassaDTO.build();
    }

    protected List<Conversao> conversaoDTOListToConversaoList(List<ConversaoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Conversao> list1 = new ArrayList<Conversao>( list.size() );
        for ( ConversaoDTO conversaoDTO : list ) {
            list1.add( dtoToDomain( conversaoDTO ) );
        }

        return list1;
    }

    protected List<ConversaoDTO> conversaoListToConversaoDTOList(List<Conversao> list) {
        if ( list == null ) {
            return null;
        }

        List<ConversaoDTO> list1 = new ArrayList<ConversaoDTO>( list.size() );
        for ( Conversao conversao : list ) {
            list1.add( domainToDto( conversao ) );
        }

        return list1;
    }
}
