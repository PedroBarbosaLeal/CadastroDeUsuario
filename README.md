# API de Cadastro de Usuários 🚀

Esta é uma API REST desenvolvida em Spring Boot para gerenciar um cadastro simples de usuários. O projeto demonstra as operações básicas de um CRUD (Create, Read, Update, Delete) e implementa boas práticas de desenvolvimento de APIs, como o uso de DTOs, tratamento de exceções e códigos de status HTTP semânticos.

---

## ✨ Funcionalidades

* **Criar** um novo usuário.
* **Listar** todos os usuários cadastrados.
* **Atualizar** informações de um usuário existente (idade e descrição).
* **Deletar** um usuário pelo seu ID.
* Validação de dados de entrada (e.g., e-mail em formato válido, campos não nulos).
* Tratamento de erros de negócio (e.g., tentativa de cadastrar e-mail duplicado).

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Web:** Para a construção dos endpoints REST.
* **Spring Data JPA:** Para a persistência de dados.
* **Hibernate:** Como implementação da JPA.
* **Spring Validation:** Para a validação dos dados de entrada.
* **PostgreSQL:** Como banco de dados.
* **Maven:** Como gerenciador de dependências e build.

---

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
* [Maven 3.8](https://maven.apache.org/download.cgi) ou superior.
* [PostgreSQL](https://www.postgresql.org/download/) rodando em sua máquina.
* Uma IDE de sua preferência (IntelliJ, VS Code, Eclipse).
* Uma ferramenta para testar APIs, como [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/downloads/).

---

## 🏁 Como Rodar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    cd seu-repositorio
    ```

2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no seu PostgreSQL. Por exemplo, `db_usuarios`.
    * Abra o arquivo `src/main/resources/application.properties`.
    * Altere as propriedades abaixo com os dados do seu banco:

    ```properties
    # Endereço do seu banco, porta e nome do banco de dados
    spring.datasource.url=jdbc:postgresql://localhost:5432/db_usuarios

    # Seu usuário e senha do PostgreSQL
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha

    # Configuração do Hibernate para criar/atualizar o banco automaticamente (ótimo para dev)
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Execute a aplicação:**
    * Abra um terminal na raiz do projeto e execute o seguinte comando Maven:
    ```bash
    mvn spring-boot:run
    ```
* A API estará disponível em `http://localhost:8080`.

---

## 📚 Endpoints da API

A URL base para todos os endpoints é `/Usuario`.

### 1. Cadastrar Usuário

* **Método:** `POST`
* **URL:** `/usuarios`
* **Corpo da Requisição (Body):**
    ```json
    {
        "nome": "João da Silva",
        "idade": 30,
        "email": "joao.silva@example.com",
        "descricao": "Desenvolvedor Backend."
    }
    ```
* **Respostas:**
    * `201 Created`: Usuário criado com sucesso. Retorna o objeto do usuário recém-criado no corpo da resposta.
    * `400 Bad Request`: Erro de validação (e.g., e-mail inválido, campo obrigatório em branco).
    * `409 Conflict`: O e-mail enviado já está cadastrado no sistema.

### 2. Listar Todos os Usuários

* **Método:** `GET`
* **URL:** `/`
* **Corpo da Requisição (Body):** Nenhum.
* **Respostas:**
    * `200 OK`: Retorna uma lista com todos os usuários cadastrados.

### 3. Atualizar Usuário

* **Método:** `PUT`
* **URL:** `/atualizar/{id}`
    * Substitua `{id}` pelo ID do usuário que deseja atualizar.
* **Corpo da Requisição (Body):**
    ```json
    {
        "idade": 31,
        "descricao": "Desenvolvedor Backend Sênior."
    }
    ```
* **Respostas:**
    * `200 OK`: Usuário atualizado com sucesso. Retorna o objeto completo do usuário com os dados atualizados.
    * `404 Not Found`: Nenhum usuário encontrado para o ID informado.

### 4. Deletar Usuário

* **Método:** `DELETE`
* **URL:** `/deletarUsuario/{id}`
    * Substitua `{id}` pelo ID do usuário que deseja deletar.
* **Corpo da Requisição (Body):** Nenhum.
* **Respostas:**
    * `204 No Content`: Usuário deletado com sucesso. Não há corpo na resposta.
    * `404 Not Found`: Nenhum usuário encontrado para o ID informado.

---

## ✒️ Autor

* **[Pedro Leal]** - [meu-linkedin](https://www.linkedin.com/in/pedro-leal-developer/)
