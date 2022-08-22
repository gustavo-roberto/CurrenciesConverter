package br.com.itau.ada.squad2.exception;

public class CurrencyNotFoundException extends RuntimeException{
    public CurrencyNotFoundException(String message){
        super(message);
    }
}
