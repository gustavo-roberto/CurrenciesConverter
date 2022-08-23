package br.com.itau.ada.squad2.viewer;


import br.com.itau.ada.squad2.exception.CurrencyNotFoundException;
import br.com.itau.ada.squad2.model.CurrencyConverter;
import br.com.itau.ada.squad2.model.dto.ConversionResultDTO;
import br.com.itau.ada.squad2.model.factory.CurrenciesFactory;
import br.com.itau.ada.squad2.util.Messages;

import java.util.Optional;

public class UserInterface {
    private final Input input;
    private final Output output;

    public UserInterface(Input input, Output output){
        this.input = input;
        this.output = output;
    }

    public void menu(){
        var option  = 0;
        do {
            Double startValue = getStartValue();
            option = getOption();
            var conversionResult = generateConversionResult(option, startValue);
            output.ShowValues(startValue, conversionResult);
        } while (option !=0 );
    }

    private Double getStartValue() {
        output.showMessage(Messages.INPUT_MONETARY_VALUE_MESSAGE.getMessage());
        var startValue = input.getDouble();
        validateExit(startValue);
        return startValue;
    }

    private int getOption() {
        output.showMessage(Messages.INPUT_OPTION_MESSAGE.getMessage());
        var option = input.getInt();
        validateExit(option);
        return option;
    }


    private ConversionResultDTO generateConversionResult(int option, double startValue){
        var currency = getCurrencyConverter(option);
        var iof = currency.operationIof(startValue);
        var taxes = currency.operationTax(startValue);
        var totalConverted = currency.convert(startValue);
        var currencySymbol = currency.getSymbol();
        return new ConversionResultDTO(iof, taxes, totalConverted, currencySymbol);
    }

    private CurrencyConverter getCurrencyConverter(int option) {
        Optional<CurrencyConverter> currency =  Optional.empty();
        try {
            currency =  Optional.ofNullable(new CurrenciesFactory().create(option));
        } catch(CurrencyNotFoundException ex) {
            output.showMessage(Messages.INVALID_INPUT.getMessage());
            var newOption = input.getInt();
            return getCurrencyConverter(newOption);
        }

        return currency.get();
    }

    private void validateExit(Number value){
        if(value.doubleValue() == 0){
            output.showMessage(Messages.EXIT_MESSAGE.getMessage());
            System.exit(0);
        }
    }




}
