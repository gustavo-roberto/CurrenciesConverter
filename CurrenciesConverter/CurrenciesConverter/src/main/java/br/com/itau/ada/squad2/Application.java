package br.com.itau.ada.squad2;

import br.com.itau.ada.squad2.viwer.UserInterface;
import br.com.itau.ada.squad2.viwer.impl.CurrencyInput;
import br.com.itau.ada.squad2.viwer.impl.CurrencyOutput;

public class Application {
    public static void main(String[] args) {
        var output = new CurrencyOutput();
        var input = new CurrencyInput(output);
        UserInterface userInterface = new UserInterface(input, output);
        userInterface.menu();
    }
}
