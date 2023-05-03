package br.com.currencyconverter.adapter.in.util;

import javax.persistence.Column;

public class Constants {

    public static final class Repository {
        public static final String BUSCAR_MOEDAS_POR_CODIGO = "SELECT COD_CURRENCY_CONVERTER, DATA_COTACAO, MOEDA_ORIGEM, MOEDA_FINAL, VALOR FROM TB_CURRENCY_CONVERTER WHERE COD_CURRENCY_CONVERTER = :cod";
    }

    public static final class Headers {
        public static final String HEADER_X_ITAU_CORRELATIONID = "x-itau-correlationID";
    }

}