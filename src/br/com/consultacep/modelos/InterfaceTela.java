package br.com.consultacep.modelos;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InterfaceTela {

    private String cep = null;
    public String solicitaCep() {
        boolean valido = false;

        Scanner leitura = new Scanner(System.in);
        while(!valido) {
            System.out.println("Digite um numero de CEP: ");
            cep = leitura.nextLine();

            if(!verificaValidadeCep(cep) || cep.length() != 8) {
                System.out.println("Favor informar um CEP valido!");
            } else {
                valido = true;
            }
        }
        leitura.close();
        return cep;
    }

    private boolean verificaValidadeCep(String cep) {return Pattern.matches("[0-9]+", cep);}
}
