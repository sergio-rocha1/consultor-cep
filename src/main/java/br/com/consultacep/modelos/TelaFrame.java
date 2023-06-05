package br.com.consultacep.modelos;

import javax.swing.*;
import java.awt.*;


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

        AcessoAPI acessoAPI = new AcessoAPI();
        try {
            Endereco endereco = acessoAPI.buscaEndereco(cep);

            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.geraJson(endereco);

            // Exibir o resultado na tela
            textAreaResultado.setText(endereco.logradouro() + "\n"
                    + endereco.bairro() + "\n"
                    + endereco.uf());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + "Finalizando aplicação!");
        }
    }
}
