package br.com.itau.ada.squad2.viewer.impl;

import br.com.itau.ada.squad2.model.dto.ConversionResultDTO;
import br.com.itau.ada.squad2.util.Messages;
import br.com.itau.ada.squad2.viewer.Output;

public class CurrencyOutput implements Output {

    @Override
    public void showMessage(String message){
        System.out.println(message);
    }

    @Override
    public void ShowValues(Double startValue, ConversionResultDTO conversionResult) {
        var message = new StringBuilder()
                .append(Messages.VALOR_IN_REAL.getMessage()).append(String.format(" R$ %.2f%n", startValue))
                .append(Messages.VALUE_IOF.getMessage()).append(String.format(" R$ %.2f%n", conversionResult.getIof()))
                .append(Messages.VALUE_OPERATION_TAX.getMessage()).append(String.format(" R$ %.2f%n", conversionResult.getTaxes()))
                .append(Messages.SEPARATOR.getMessage()).append("\n")
                .append(Messages.VALUE_TOTAL_CONVERTED.getMessage()).append(String.format(" %s %.2f%n", conversionResult.getCurrencySymbol(), conversionResult.getTotalConverted()));
        System.out.println(message.toString());
    }


}
