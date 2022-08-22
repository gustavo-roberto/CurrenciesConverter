package br.com.itau.ada.squad2.viwer;

import br.com.itau.ada.squad2.model.dto.ConversionResultDTO;

public interface Output {
    void showMessage(String message);
    void ShowValues(Double startValue, ConversionResultDTO conversionResult);
}
