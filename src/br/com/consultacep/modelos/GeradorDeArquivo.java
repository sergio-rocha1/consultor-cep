package br.com.consultacep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void geraJson(Endereco endereco) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nomeArquivo = endereco.cep() + ".json";

        FileWriter arquivo = new FileWriter(nomeArquivo);
        arquivo.write(gson.toJson(endereco));
        System.out.println("Arquivo de nome " + nomeArquivo +" gerado com sucesso!");

        arquivo.close();
    }
}
