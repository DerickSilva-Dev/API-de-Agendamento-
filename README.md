# API de Agenda - Gerenciamento de Compromissos

Uma API RESTful leve e rápida desenvolvida em Java com Spring Boot para gerenciamento de eventos e compromissos. Este projeto foi criado com foco em praticar a construção de rotas, separação de responsabilidades e manipulação de dados em memória.

## Tecnologias e Arquitetura

* **Java & Spring Boot:** Framework base para mapeamento das rotas REST e injeção de dependências.
* **Armazenamento em Memória (Thread-safe):** Utilização de `ConcurrentHashMap` no Service para simular um banco de dados rápido e seguro contra concorrência durante o tempo de execução.
* **Padrão DTO (Data Transfer Object):** Separação estrita entre a entidade de domínio (`Agenda`) e os dados expostos nas requisições (`AgendaRequestDTO` e `AgendaResponseDTO`).
* **Jakarta Validation:** Validação de dados de entrada diretamente no Controller (`@NotBlank`, `@NotNull`), garantindo a integridade das informações antes do processamento.
* **Lombok:** Redução de código boilerplate (Getters, Setters, Construtores).

## ️ Como Executar o Projeto

1. Certifique-se de ter o Java JDK e o Maven instalados.
2. Faça o clone deste repositório:
   ```bash
   git clone https://github.com/DerickSilva-Dev/API-de-Agendamento-.git
   ```
3. Abra o projeto na sua IDE (IntelliJ IDEA, Eclipse, VS Code).
4. Execute a classe principal `DesafioApplication`.
5. A aplicação estará disponível localmente em `http://localhost:8080/agenda`.

## Endpoints da API

Abaixo estão os endpoints disponíveis. Recomenda-se o uso do Postman ou Insomnia para testes.

### 1. Cadastrar Evento
- **Método:** `POST`
- **Rota:** `/agenda/cadastro`
- **Corpo da Requisição (JSON):**
  ```json
  {
    "nome": "Entrevista Técnica Backend",
    "data": "2026-12-05",
    "concluido": "true"
  }
  ```
- **Retorno de Sucesso:** `201 Created`

### 2. Listar Todos os Eventos
- **Método:** `GET`
- **Rota:** `/agenda/listar`
- **Retorno de Sucesso:** `200 OK` (Retorna um array JSON com todos os DTOs).

### 3. Buscar Evento por ID
- **Método:** `GET`
- **Rota:** `/agenda/listar/{id}`
- **Retornos:** 
  - `200 OK` (Dados do evento)
  - `404 Not Found` (Se o ID não existir)

### 4. Atualizar Evento
- **Método:** `PUT`
- **Rota:** `/agenda/alterar/{id}`
- **Corpo da Requisição (JSON):**
  ```json
  {
    "nome": "Entrevista Técnica Backend - Remarcada",
    "data": "2026-10-16",
    "concluido": "true"
  }
  ```
- **Retornos:** 
  - `200 OK` (Sucesso)
  - `404 Not Found` (Se o ID não existir)

### 5. Excluir Evento
- **Método:** `DELETE`
- **Rota:** `/agenda/excluir/{id}`
- **Retornos:** 
  - `204 No Content` (Excluído com sucesso)
  - `404 Not Found` (Se o ID não existir)  
