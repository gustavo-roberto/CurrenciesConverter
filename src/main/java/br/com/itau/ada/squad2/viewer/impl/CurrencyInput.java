package br.com.itau.ada.squad2.viewer.impl;

import br.com.itau.ada.squad2.util.Messages;
import br.com.itau.ada.squad2.viewer.Input;
import br.com.itau.ada.squad2.viewer.Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyInput implements Input {

    private  final Output output;

    public CurrencyInput(Output output){
        this.output = output;
    }

    @Override
    public Double getDouble(){
        while(true) {
            try {
                return new Scanner(System.in).nextDouble();
            } catch (InputMismatchException ex) {
                output.showMessage(Messages.INVALID_INPUT.getMessage());
            }
        }
    }

    @Override
    public Integer getInt(){
        while (true){
            try {
                return new Scanner(System.in).nextInt();
            }catch(InputMismatchException ex){
                output.showMessage(Messages.INVALID_INPUT.getMessage());
            }
        }
    }
}
