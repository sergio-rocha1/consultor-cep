<h1 align="center"> Consultor de CEP </h1>
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>

# 📝 Descrição do Projeto
Projeto em desenvolvimento para consolidar os conhecimentos em API, no curso oferecido pela Alura. É feito uma busca
de um CEP via API ViaCEP. No estado atual do projeto a consulta é feita via prompt de comando, 
passando o CEP e retornando um arquivo .json com o resultado da consulta gerada.

O próximo passo do projeto (Já em andamento) é fazer a criação de uma interface gráfica com JFrame, para que o usuario
informe na interface o CEP e ela retorne para ele o resultado, tendo a possibilidade da geração do arquivo .json.

# 📌 Funcionalidades atuais do projeto
- `Funcionalidade 1`: Solicitação do CEP via prompt de comando;
- `Funcionalidade 2`: Verificação se o CEP atende aos requisitos;
- `Funcionalidade 3`: Busca do CEP via API do **ViaCEP**; (Web-service)
- `Funcionalidade 3`: Geração de arquivo .json com informações do CEP buscado.

# 🛠️ Abrir e rodar o projeto
Após clonar o projeto, você pode abrir com a sua IDE de preferência.
- Após abrir o projeto na sua IDE, acessar a classe "Principal" e execute-a.
- No prompt de comando, informe um CEP.
- O programa será executado e irá retornar na pasta do projeto um arquivo com o seguinte nome *"XXXXX-XX.json"*

# ✔ Técnicas e tecnologias utilizadas
- `Java 16`
- `Web-service do ViaCEP (API)`
- `Biblioteca externa GSON (Google)`
- `IntelLiJ IDEA`
