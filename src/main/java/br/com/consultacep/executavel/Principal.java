package br.com.consultacep.executavel;

import br.com.consultacep.modelos.AcessoAPI;
import br.com.consultacep.modelos.Endereco;
import br.com.consultacep.modelos.GeradorDeArquivo;
import br.com.consultacep.modelos.InterfaceTela;


public class Principal {
    public static void main(String[] args) {

        InterfaceTela interfaceTela = new InterfaceTela();
        String cep = interfaceTela.solicitaCep();
        AcessoAPI acessoAPI = new AcessoAPI();
        try {
            Endereco endereco = acessoAPI.buscaEndereco(cep);
            System.out.println(endereco.toString());

            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.geraJson(endereco);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação!");
        }
    }
}
