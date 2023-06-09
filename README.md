<h1 align="center"> Consultor de CEP </h1>
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>

# 📝 Descrição do Projeto
Projeto em desenvolvimento para consolidar os conhecimentos em API, no curso oferecido pela Alura. É feito uma busca
de um CEP via API ViaCEP. No estado atual do projeto a consulta é feita via interface gráfica utilizando JFrame, 
passando o CEP e retornando informações do CEP, com a possibilidade de geração de um arquivo .json com o resultado da consulta gerada.

O próximo passo do projeto (Já em andamento) é realizar a padronização do código (Com a abstração e encapsulamento de alguns métodos), para facilitar a manutenção do mesmo, bem como implementar
novas funcionalidade no projeto.

# 📌 Funcionalidades atuais do projeto
- `Funcionalidade 1`: Solicitação do CEP via interface;
- `Funcionalidade 2`: Verificação se o CEP atende aos requisitos (Somente números e 8 digitos);
- `Funcionalidade 3`: Busca do CEP via API do **ViaCEP**; (Web-service);
- `Funcionalidade 4`: Retorno da busca na interface com Logradouro, Bairro e Estado.
- `Funcionalidade 5`: Possibilidade de geração de arquivo .json com informações do CEP buscado via interface.

# 🛠️ Abrir e rodar o projeto
Após clonar o projeto, você pode abrir com a sua IDE de preferência.
- Instalar o Java JDK 16 ([Tutorial de instalação](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html))
- Instalar gerenciador de dependencias Maven ([Tutorial de instalação](https://dicasdeprogramacao.com.br/como-instalar-o-maven-no-windows/))
- Após abrir o projeto na sua IDE, acessar a classe "PrincipalComTela" e execute-a.
- Informar um CEP na interface gráfica.
- O programa será executado e irá retornar na pasta do projeto um arquivo com o seguinte nome *"XXXXX-XX.json"* (Caso selecionado SIM na caixa de dialogo da interface)

# ✔ Técnicas e tecnologias utilizadas
- `Java 16`
- `Maven 3.9.2`
- `Web-service do ViaCEP (API)`
- `Biblioteca externa GSON (Google)`
- `IntelLiJ IDEA`