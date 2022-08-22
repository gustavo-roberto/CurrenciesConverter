package br.com.itau.ada.squad2.util;

public enum Messages {
    INPUT_MONETARY_VALUE_MESSAGE("Digite o valor em reais (R$) ou '0' para sair"),
    INPUT_OPTION_MESSAGE("Digite a moeda de destino: \n 1.Euro\n 2.Dólar\n 3.Peso Argentino\n 4.Peso Chileno\n 0.Sair"),
    VALOR_IN_REAL("Valor em reais ->"),
    VALUE_IOF("IOF ->"),
    VALUE_OPERATION_TAX("Taxa de operação ->"),
    VALUE_TOTAL_CONVERTED("Total Convertido ->"),
    ERRO_INPUT_MISMATCH_EXCEPTION("Informe uma entrada válida."),
    SEPARATOR("-----------------------------"),
    EXIT_MESSAGE("Fim da execução :)");

    private final String message;

    public  String getMessage(){
        return message;
    }

    Messages(String message){
        this.message = message;
    }
}
