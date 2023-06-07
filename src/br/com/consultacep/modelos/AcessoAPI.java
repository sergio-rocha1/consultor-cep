package br.com.consultacep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AcessoAPI {

    private URI geraEnderecoUrl(String cep) {
        return URI.create("https://viacep.com.br/ws/" + cep + "/json/");
    }

    private HttpResponse<String> geraRequisicaoResposta(URI endereco) throws Exception {

        try {
            // Cria um objeto HttpClient para enviar a requisição HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria um objeto HttpRequest com a URL construída
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco).build();

            // Envia a requisição HTTP e armazena a resposta na variável 'response'
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch(Exception e) {
            throw new Exception("CEP não identificado, favor verificar");
        }
    }

    public Endereco buscaEndereco(String cep) throws Exception {

        URI uri = this.geraEnderecoUrl(cep);
        HttpResponse<String> response = this.geraRequisicaoResposta(uri);

        // Cria um objeto Gson para fazer a desserialização do JSON
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.fromJson(response.body(), Endereco.class);
    }



}
