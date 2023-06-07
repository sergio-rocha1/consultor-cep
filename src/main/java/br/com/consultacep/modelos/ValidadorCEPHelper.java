package br.com.consultacep.modelos;

import java.util.regex.Pattern;

public abstract class ValidadorCEPHelper {

    public static boolean validaCep(String cep) {
        return (verificaCepOitoNumeros(cep) && cep.length() == 8);
    }

    private static boolean verificaCepOitoNumeros(String cep) {return Pattern.matches("[0-9]+", cep);}

}
