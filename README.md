# To-Do List em Java com JDBC

## Descrição

Este é um projeto de To-Do List desenvolvido em Java, utilizando JDBC para integração com um banco de dados relacional. O objetivo deste projeto é aprofundar o conhecimento sobre bancos de dados relacionais e aprimorar a utilização do JDBC para construir aplicações mais robustas.

## Funcionalidades

- Criar uma nova tarefa
- Editar uma tarefa existente
- Visualizar uma tarefa por ID
- Visualizar tarefas por descrição
- Criar mais de uma lista de tarefas

## Tecnologias Utilizadas

- Java
- JDBC
- Banco de Dados Relacional (MySQL, PostgreSQL ou outro de sua escolha)

## Como Executar o Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/todo-list-java.git
    ```

2. Configure o banco de dados:
    - Crie um banco de dados no seu SGBD de preferência.
    - Execute o script MYSQL para criar as tabelas necessárias.
    - Configure a conexão JDBC no arquivo de configuração do projeto.

3. Compile e execute a aplicação:

    ```bash
    javac Main.java
    java Main
    ```

## Estrutura do Banco de Dados

Exemplo de estrutura para a tabela de tarefas:

```sql
CREATE TABLE tarefas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    concluida BOOLEAN DEFAULT FALSE,
    lista_id INT,
    FOREIGN KEY (lista_id) REFERENCES listas(id)
);

CREATE TABLE listas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);
