package br.com.currencyconverter.adapter.out.database.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taxas_cambio")
public class TaxaCambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "moeda_base", nullable = false)
    private String moedaBase;

    @Column(name = "moeda_destino", nullable = false)
    private String moedaDestino;

    @Column(name = "taxa_cambio", nullable = false)
    private BigDecimal taxaCambio;
}

