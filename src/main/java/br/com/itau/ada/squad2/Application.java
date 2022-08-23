package br.com.itau.ada.squad2;

import br.com.itau.ada.squad2.viewer.UserInterface;
import br.com.itau.ada.squad2.viewer.impl.CurrencyInput;
import br.com.itau.ada.squad2.viewer.impl.CurrencyOutput;

public class Application {
    public static void main(String[] args) {
        var output = new CurrencyOutput();
        var input = new CurrencyInput(output);
        UserInterface userInterface = new UserInterface(input, output);
        userInterface.menu();
    }
}
