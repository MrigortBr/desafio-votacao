# Desafio votação
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/MrigortBr/desafio-votacao/blob/main/LICENSE)![Build Passed](https://img.shields.io/badge/build-passing-brightgreen)
## Objetivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. Imagine que você deve criar uma solução para dispositivos móveis para gerenciar e participar dessas sessões de votação. Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:

Cadastrar uma nova pauta
Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)
Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta)
Contabilizar os votos e dar o resultado da votação na pauta
Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A solução deve ser construída em java, usando Spring-boot, mas os frameworks e bibliotecas são de livre escolha (desde que não infrinja direitos de uso).

É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.

O foco dessa avaliação é a comunicação entre o backend e o aplicativo mobile. Essa comunicação é feita através de mensagens no formato JSON, onde essas mensagens serão interpretadas pelo cliente para montar as telas onde o usuário vai interagir com o sistema. A aplicação cliente não faz parte da avaliação, apenas os componentes do servidor.
## Instruções de Instalação e Execução

1. Clone o repositório: `git clone https://github.com/MrigortBr/desafio-votacao.git`
2. Configure o ambiente de desenvolvimento conforme necessário (Java, Maven, Docker, etc.).
3. Configure o banco de dados MySQL e atualize as configurações de conexão no arquivo `application.properties`.
4. Execute a aplicação Spring Boot usando o Maven: `mvn spring-boot:run`.
5. Acesse os endpoints da API utilizando o Postman ou outra ferramenta similar.
## Tecnologias Usadas

### Dependências

- **Spring Boot Starter Data JPA**: Framework de persistência de dados.
- **Spring Boot Starter Validation**: Biblioteca para validação de dados.
- **Spring Boot Starter Web**: Framework para construção de aplicações web.
- **Spring Boot Starter Test**: Biblioteca para testes automatizados.
- **Spring Boot DevTools**: Ferramentas para desenvolvimento ágil.
- **MySQL Connector Java**: Conector JDBC para MySQL.
- **Lombok**: Biblioteca para simplificação de código Java.

Para mais detalhes das dependências veja o arquivo [POM.XML](https://github.com/MrigortBr/desafio-votacao/blob/main/pom.xml)

### Tecnologias

- **Java**: Linguagem de programação principal.
- **Maven**: Gerenciador de dependências e construção de projetos.
- **Docker**: Plataforma para desenvolvimento, envio e execução de aplicações em containers.
- **Mysql**: Sistema de gerenciamento de banco de dados.

### Ferramentas de Desenvolvimento

- **Postman**: Ferramenta para testar APIs.
- **Spring Tool Suite**: IDE baseada em Eclipse para desenvolvimento Spring.
- **DBeaver**: Ferramenta de administração de banco de dados universal e gratuita.

## Endpoints da API
Para utilizar de forma mais rapida todos os endpoints basta utilizar a [base](https://github.com/MrigortBr/desafio-votacao/blob/main/Vota%C3%A7%C3%A3o.postman_collection.json) para o [postman](https://www.postman.com/downloads/).

A API expõe os seguintes endpoints:

### User

- **ListAll**
  - **Descrição:** Retorna todos os usuários cadastrados.
  - **Método HTTP:** GET
  - **Endpoint:** `http://localhost:8080/v1/user`

- **ListById**
  - **Descrição:** Retorna um usuário específico pelo ID.
  - **Método HTTP:** GET
  - **Endpoint:** `http://localhost:8080/v1/user/{id}`

- **Create**
  - **Descrição:** Cria um novo usuário com nome e CPF.
  - **Método HTTP:** POST
  - **Endpoint:** `http://localhost:8080/v1/user`
  - **Exemplo de Corpo da Requisição:**
    ```json
    {
        "name": "Igor Pereira",
        "cpf": "123"
    }
    ```

- **Delete**
  - **Descrição:** Remove um usuário específico pelo ID.
  - **Método HTTP:** DELETE
  - **Endpoint:** `http://localhost:8080/v1/user/{id}`

- **Update**
  - **Descrição:** Atualiza os dados de um usuário específico pelo ID.
  - **Método HTTP:** PUT
  - **Endpoint:** `http://localhost:8080/v1/user/{id}`
  - **Exemplo de Corpo da Requisição:**
    ```json
    {
        "name": "Igor Pereira Lins",
        "cpf": "85154641019"
    }
    ```

### Topic

- **ListAll**
  - **Descrição:** Retorna todas as pautas cadastradas.
  - **Método HTTP:** GET
  - **Endpoint:** `http://localhost:8080/v1/topic`

- **ListById**
  - **Descrição:** Retorna uma pauta específica pelo ID.
  - **Método HTTP:** GET
  - **Endpoint:** `http://localhost:8080/v1/topic/{id}`

- **Create**
  - **Descrição:** Cria uma nova pauta com nome e conteúdo.
  - **Método HTTP:** POST
  - **Endpoint:** `http://localhost:8080/v1/topic`
  - **Exemplo de Corpo da Requisição:**
    ```json
    {
        "name": "ECO",
        "content": "Sistema de Economia para a empresa, terá um crescimento de 50%"
    }
    ```

### Session

- **ListAll**
  - **Descrição:** Retorna todas as sessões de votação cadastradas.
  - **Método HTTP:** GET
  - **Endpoint:** `http://localhost:8080/v1/session`

- **ListById**
  - **Descrição:** Retorna uma sessão de votação específica pelo ID.
  - **Método HTTP:** GET
  - **Endpoint:** `http://localhost:8080/v1/session/{id}`

- **Create**
  - **Descrição:** Abre uma nova sessão de votação para uma pauta específica.
  - **Método HTTP:** POST
  - **Endpoint:** `http://localhost:8080/v1/session`
  - **Exemplo de Corpo da Requisição:**
    ```json
    {
        "idTopic": 1,
        "sessionStart": "2024-06-17T01:37:51",
        "sessionEnd": "2024-06-21T01:38:51"
    }
    ```

### Vote

- **Create**
  - **Descrição:** Registra o voto de um usuário em uma pauta específica.
  - **Método HTTP:** POST
  - **Endpoint:** `http://localhost:8080/v1/vote`
  - **Exemplo de Corpo da Requisição:**
    ```json
    {
        "idTopic": 1,
        "typeVote": "SIM",
        "idUser": 1
    }
    ```



## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](https://github.com/MrigortBr/desafio-votacao/blob/main/LICENSE) para detalhes.
