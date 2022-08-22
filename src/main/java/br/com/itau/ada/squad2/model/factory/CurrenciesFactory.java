package br.com.itau.ada.squad2.model.factory;

import br.com.itau.ada.squad2.exception.CurrencyNotFoundException;
import br.com.itau.ada.squad2.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CurrenciesFactory {
    private static final Map<Integer, CurrencyConverter> currencies;
    static{
        currencies = new HashMap<>();
        currencies.put(1, new EuroConverter());
        currencies.put(2, new DollarConverter());
        currencies.put(3, new ArgentinianPesoConverter());
        currencies.put(4, new ChileanPesoConverter());
    }

    public CurrencyConverter create(Integer number){
        return Optional.ofNullable(currencies.get(number)).orElseThrow(()-> new CurrencyNotFoundException("The informed currency does not exist!"));
    }
}
