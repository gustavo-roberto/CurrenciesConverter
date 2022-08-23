package br.com.itau.ada.squad2.model;

public abstract class CurrencyConverter {
    protected static final double IOF = 1.1;
    protected final String CURRENCY_SYMBOL;
    protected final double QUOTATION;
    protected final double TAX_IN_REAL;
    protected final double TAX_PERCENTUAL;

    public String getSymbol(){
        return CURRENCY_SYMBOL;
    }

    protected CurrencyConverter(String currencySymbol, double quotation, double taxInReal, double taxPercentual){
        this.CURRENCY_SYMBOL = currencySymbol;
        this.QUOTATION = quotation;
        this.TAX_IN_REAL = taxInReal;
        this.TAX_PERCENTUAL = taxPercentual;
    }

    public final double convert(double valueInReal){
        return (valueInReal - operationIof(valueInReal) - operationTax(valueInReal)) * QUOTATION;
    }
    public double operationIof(double valueInReal){
        return valueInReal * (IOF / 100);
    }

    public double operationTax(double valueInReal){
        return TAX_IN_REAL + (valueInReal * TAX_PERCENTUAL / 100);
    }

}
