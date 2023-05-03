package br.com.currencyconverter.adapter.out.database.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_conversoes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversaoHistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "moeda_origem", nullable = false)
    private String moedaOrigem;

    @Column(name = "moeda_destino", nullable = false)
    private String moedaDestino;

    @Column(name = "valor_origem", nullable = false)
    private BigDecimal valorOrigem;

    @Column(name = "valor_convertido", nullable = false)
    private BigDecimal valorConvertido;

    @Column(name = "data_conversao", nullable = false)
    private LocalDateTime dataConversao;
}
