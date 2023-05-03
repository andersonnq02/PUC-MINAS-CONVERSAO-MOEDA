package br.com.currencyconverter.core.usecase;

import br.com.currencyconverter.adapter.out.api.dto.ExchangeRatesApiResponse;
import br.com.currencyconverter.core.dominio.Moeda;
import br.com.currencyconverter.core.port.in.MoedaUseCase;
import br.com.currencyconverter.core.port.out.ExchangeRatesApiPort;
import br.com.currencyconverter.core.port.out.MoedaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MoedaUseCaseImpl implements MoedaUseCase {

    private final MoedaPort moedaPort;

    @Override
    public Moeda adicionarMoeda(Moeda moeda) {
        return moedaPort.adicionarMoeda(moeda);
    }

    @Override
    public Moeda atualizarMoeda(String codigo, Moeda moeda) {
        return moedaPort.atualizarMoeda(codigo, moeda);
    }

    @Override
    public void removerMoeda(String codigo) {
        moedaPort.removerMoeda(codigo);
    }

    @Override
    public List<Moeda> listarMoedas() {
        return moedaPort.listarMoedas();
    }
}
