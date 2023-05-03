package br.com.currencyconverter.adapter.out.database.repository;

import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedaRepository extends JpaRepository<MoedaEntity, String> {
}
