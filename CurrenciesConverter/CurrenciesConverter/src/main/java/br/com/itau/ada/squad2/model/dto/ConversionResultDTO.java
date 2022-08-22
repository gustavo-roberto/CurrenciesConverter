package br.com.itau.ada.squad2.model.dto;

public class ConversionResultDTO {

    private double iof;
    private double taxes;
    private double totalConverted;
    private String currencySymbol;

    public ConversionResultDTO(double iof, double taxes, double totalConverted, String currencySymbol){
        this.iof = iof;
        this.taxes = taxes;
        this.totalConverted = totalConverted;
        this.currencySymbol = currencySymbol;
    }

    public double getIof() {
        return iof;
    }

    public void setIof(double iof) {
        this.iof = iof;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTotalConverted() {
        return totalConverted;
    }

    public void setTotalConverted(double totalConverted) {
        this.totalConverted = totalConverted;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
