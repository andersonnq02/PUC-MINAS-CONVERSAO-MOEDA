package br.com.currencyconverter.adapter.out.database.repository;

import br.com.currencyconverter.adapter.out.database.entity.ConversaoHistoricoEntity;
import br.com.currencyconverter.core.dominio.ConversaoHistoricoFiltro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversaoHistoricoRepository extends JpaRepository<ConversaoHistoricoEntity, Long> {

    @Query("SELECT h FROM ConversaoHistoricoEntity h WHERE " +
            "(:#{#filtro.moedaOrigem} IS NULL OR h.moedaOrigem = :#{#filtro.moedaOrigem}) AND " +
            "(:#{#filtro.moedaDestino} IS NULL OR h.moedaDestino = :#{#filtro.moedaDestino}) AND " +
            "(:#{#filtro.dataInicio} IS NULL OR h.dataConversao >= :#{#filtro.dataInicio}) AND " +
            "(:#{#filtro.dataFim} IS NULL OR h.dataConversao <= :#{#filtro.dataFim}) AND " +
            "(:#{#filtro.valorMinimo} IS NULL OR h.valorOrigem >= :#{#filtro.valorMinimo}) AND " +
            "(:#{#filtro.valorMaximo} IS NULL OR h.valorOrigem <= :#{#filtro.valorMaximo})")
    List<ConversaoHistoricoEntity> findByFiltro(@Param("filtro") ConversaoHistoricoFiltro filtro);
}
