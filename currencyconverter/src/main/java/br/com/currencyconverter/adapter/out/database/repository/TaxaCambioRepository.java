package br.com.currencyconverter.adapter.out.database.repository;

import br.com.currencyconverter.adapter.out.database.entity.TaxaCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaxaCambioRepository extends JpaRepository<TaxaCambioEntity, Long> {
    @Query("SELECT t FROM TaxaCambioEntity t WHERE t.moedaBase = :moedaBase")
    List<TaxaCambioEntity> findByMoedaBase(@Param("moedaBase") String moedaBase);

    @Query("SELECT t FROM TaxaCambioEntity t WHERE t.moedaBase = :moedaBase AND t.moedaDestino = :moedaDestino")
    Optional<TaxaCambioEntity> findByMoedaBaseAndMoedaDestino(@Param("moedaBase") String moedaBase, @Param("moedaDestino") String moedaDestino);

}