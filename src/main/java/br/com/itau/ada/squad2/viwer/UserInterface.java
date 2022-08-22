package br.com.itau.ada.squad2.viwer;


import br.com.itau.ada.squad2.model.dto.ConversionResultDTO;
import br.com.itau.ada.squad2.model.factory.CurrenciesFactory;
import br.com.itau.ada.squad2.util.Messages;

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
            output.showMessage(Messages.INPUT_MONETARY_VALUE_MESSAGE.getMessage());
            var startValue = input.getDouble();
            validateExit(startValue);
            output.showMessage(Messages.INPUT_OPTION_MESSAGE.getMessage());
            option = input.getInt();
            validateExit(option);
            var conversionResult = generateConversionResult(option, startValue);
            output.ShowValues(startValue, conversionResult);
        } while (option !=0 );
    }

    private ConversionResultDTO generateConversionResult(int option, double startValue){
        var currency = new CurrenciesFactory().create(option);
        var iof = currency.operatioIof(startValue);
        var taxes = currency.convert(startValue);
        var totalConverted = currency.convert(startValue);
        var currencySymbol = currency.getSymbol();
        return new ConversionResultDTO(iof, taxes, totalConverted, currencySymbol);
    }

    private void validateExit(Number value){
        if(value.doubleValue() == 0){
            output.showMessage(Messages.EXIT_MESSAGE.getMessage());
            System.exit(0);
        }
    }




}
