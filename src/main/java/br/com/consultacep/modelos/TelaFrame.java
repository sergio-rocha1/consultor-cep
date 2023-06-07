package br.com.consultacep.modelos;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class TelaFrame extends JFrame {

    private final JTextField campoCEP;
    private final JTextArea textAreaResultado;

    public TelaFrame() {
        super("Busca de CEP");

        // Configurações do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLayout(null);

        // Criação do campo CEP
        JLabel labelCEP = new JLabel("CEP:");
        labelCEP.setBounds(20,20,40, 25);
        add(labelCEP);

        campoCEP = new JTextField();
        campoCEP.setBounds(60, 20, 150, 25);
        add(campoCEP);

        // Criação do botão Pesquisar
        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(60, 60, 100, 25);
        botaoPesquisar.addActionListener(e -> pesquisarCEP());
        add(botaoPesquisar);

        // Criação do componente para exibir o resultado
        textAreaResultado = new JTextArea();
        textAreaResultado.setFont(new Font("Arial", Font.PLAIN, 14));
        textAreaResultado.setLineWrap(true);
        textAreaResultado.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textAreaResultado);
        scrollPane.setBounds(20, 100, 350, 150);
        add(scrollPane);
    }

    private void pesquisarCEP() {
        String cep = campoCEP.getText();

        if(ValidadorCEPHelper.validaCep(cep)) {
            AcessoAPI acessoAPI = new AcessoAPI();
            try {
                if(ValidadorCEPHelper.validaCep(cep)) {
                    Endereco endereco = acessoAPI.buscaEndereco(cep);

                    // Exibir o resultado na tela
                    textAreaResultado.setText(endereco.logradouro() + "\n"
                            + endereco.bairro() + "\n"
                            + endereco.uf());

                    Timer timer = new Timer(2000, e -> {
                        int resposta = JOptionPane.showConfirmDialog(TelaFrame.this, "Deseja gerar o arquivo do CEP informado?");
                        if (resposta == JOptionPane.YES_OPTION) {
                            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                            try {
                                geradorDeArquivo.geraJson(endereco);
                                JOptionPane.showMessageDialog(TelaFrame.this, "O arquivo foi gerado com sucesso!");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(TelaFrame.this, "Não foi possivel gerar o arquivo devido: " + ex.getMessage());
                            }
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + "Finalizando aplicação!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "O CEP informado é invalido, favor inserir novamente!");
        }

    }
}
