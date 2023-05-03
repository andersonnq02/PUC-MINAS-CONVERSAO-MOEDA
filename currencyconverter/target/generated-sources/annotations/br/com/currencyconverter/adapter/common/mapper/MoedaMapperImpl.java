package br.com.currencyconverter.adapter.common.mapper;

import br.com.currencyconverter.adapter.in.dto.MoedaDto;
import br.com.currencyconverter.adapter.in.dto.MoedaDto.MoedaDtoBuilder;
import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity;
import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity.MoedaEntityBuilder;
import br.com.currencyconverter.core.dominio.Moeda;
import br.com.currencyconverter.core.dominio.Moeda.MoedaBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-01T23:56:58-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MoedaMapperImpl implements MoedaMapper {

    @Override
    public MoedaDto domainToDto(Moeda moeda) {
        if ( moeda == null ) {
            return null;
        }

        MoedaDtoBuilder moedaDto = MoedaDto.builder();

        moedaDto.codigo( moeda.getCodigo() );
        moedaDto.nome( moeda.getNome() );
        moedaDto.simbolo( moeda.getSimbolo() );

        return moedaDto.build();
    }

    @Override
    public MoedaEntity domainToEntity(Moeda moeda) {
        if ( moeda == null ) {
            return null;
        }

        MoedaEntityBuilder moedaEntity = MoedaEntity.builder();

        moedaEntity.codigo( moeda.getCodigo() );
        moedaEntity.nome( moeda.getNome() );
        moedaEntity.simbolo( moeda.getSimbolo() );

        return moedaEntity.build();
    }

    @Override
    public Moeda entityToDomain(MoedaEntity moedaEntity) {
        if ( moedaEntity == null ) {
            return null;
        }

        MoedaBuilder moeda = Moeda.builder();

        moeda.codigo( moedaEntity.getCodigo() );
        moeda.nome( moedaEntity.getNome() );
        moeda.simbolo( moedaEntity.getSimbolo() );

        return moeda.build();
    }

    @Override
    public Moeda dtoToDomain(MoedaDto moedaDto) {
        if ( moedaDto == null ) {
            return null;
        }

        MoedaBuilder moeda = Moeda.builder();

        moeda.codigo( moedaDto.getCodigo() );
        moeda.nome( moedaDto.getNome() );
        moeda.simbolo( moedaDto.getSimbolo() );

        return moeda.build();
    }
}
