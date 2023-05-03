package br.com.currencyconverter.adapter.out.database;

import br.com.currencyconverter.adapter.common.mapper.MoedaMapper;
import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity;
import br.com.currencyconverter.adapter.out.database.repository.MoedaRepository;
import br.com.currencyconverter.core.dominio.Moeda;
import br.com.currencyconverter.core.port.out.MoedaPort;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MoedaAdapter implements MoedaPort {

    private final MoedaRepository moedaRepository;

    private final MoedaMapper moedaMapper;

    @Override
    public Moeda adicionarMoeda(Moeda moeda) {
        MoedaEntity moedaEntity = moedaMapper.domainToEntity(moeda);
        MoedaEntity moedaEntitySalva = moedaRepository.save(moedaEntity);
        return moedaMapper.entityToDomain(moedaEntitySalva);
    }

    @Override
    public Moeda atualizarMoeda(String codigo, Moeda moeda) {
        MoedaEntity moedaEntity = null;
        try {
            moedaEntity = moedaRepository.findById(codigo)
                    .orElseThrow(() -> new NotFoundException("Moeda não encontrada com o código: " + codigo));

            moedaEntity.setNome(moeda.getNome());
            moedaEntity.setSimbolo(moeda.getSimbolo());

            MoedaEntity moedaEntityAtualizada = moedaRepository.save(moedaEntity);
            return moedaMapper.entityToDomain(moedaEntityAtualizada);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerMoeda(String codigo) {
        MoedaEntity moedaEntity = null;
        try {
            moedaEntity = moedaRepository.findById(codigo)
                    .orElseThrow(() -> new NotFoundException("Moeda não encontrada com o código: " + codigo));

            moedaRepository.delete(moedaEntity);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Moeda> listarMoedas() {
        List<MoedaEntity> moedaEntities = moedaRepository.findAll();
        return moedaEntities.stream().map(moedaMapper::entityToDomain).collect(Collectors.toList());
    }
}
