package br.com.currencyconverter.core.port.in;

import br.com.currencyconverter.core.dominio.Moeda;

import java.util.List;

public interface MoedaUseCase {

    Moeda adicionarMoeda(Moeda moeda);

    Moeda atualizarMoeda(String codigo, Moeda moeda);

    void removerMoeda(String codigo);

    List<Moeda> listarMoedas();
}
