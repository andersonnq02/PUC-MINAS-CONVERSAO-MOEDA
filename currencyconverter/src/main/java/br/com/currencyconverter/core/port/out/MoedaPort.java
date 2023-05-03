package br.com.currencyconverter.core.port.out;

import br.com.currencyconverter.core.dominio.Moeda;

import java.util.List;

public interface MoedaPort {

    public Moeda adicionarMoeda(Moeda moeda);
    public Moeda atualizarMoeda(String codigo ,Moeda moeda);
    public void removerMoeda(String codigo);
    public List<Moeda> listarMoedas();
}
