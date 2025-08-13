# To-Do API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![H2](https://img.shields.io/badge/H2-%23007DB8.svg?style=for-the-badge&logo=h2&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-%23E15718.svg?style=for-the-badge&logo=lombok&logoColor=white)
[![Licence](https://img.shields.io/github/license/gustavopenha07/to-do?style=for-the-badge)](./LICENSE)
![Swagger](https://img.shields.io/badge/Swagger-%2300BC7B.svg?style=for-the-badge&logo=swagger&logoColor=white)

API RESTful para gerenciamento de tarefas (To-Do List), desenvolvida com Spring Boot.

---

## 📑 Sumário

<div align="center">

| [📝 Sobre](#sobre) | [🚀 Tecnologias](#tecnologias) | [⚙️ Como executar](#como-executar) | [🔗 Endpoints](#endpoints) | [📚 Swagger/OpenAPI](#swaggeropenapi) | [👤 Autor](#autor) |
|:------------------:|:------------------------------:|:----------------------------------:|:-------------------------:|:-------------------------------------:|:------------------:|

</div>

---

## Sobre

Esta API permite o cadastro de usuários, autenticação básica e o gerenciamento de tarefas pessoais (CRUD). Cada usuário pode criar, listar, atualizar e remover suas próprias tarefas.

## Tecnologias

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- PostgreSQL (padrão) ou H2 (runtime)
- Lombok
- Swagger/OpenAPI

## Como executar

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/gustavopenha07/to-do
   cd to-do
   ```

2. **Configure o banco de dados:**
   - Por padrão, usa PostgreSQL. Edite `src/main/resources/application.properties` se necessário.

3. **Build e execute:**
   ```sh
   ./mvnw spring-boot:run
   ```

4. **Acesse:**
   - API: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

## Endpoints

### Autenticação

| Método | Endpoint           | Descrição                | Body (JSON)                                  |
|--------|--------------------|--------------------------|----------------------------------------------|
| POST   | `/auth/register`   | Registrar novo usuário   | `{ "name": "...", "username": "...", "password": "..." }` |
| POST   | `/auth/login`      | Login do usuário         | Basic Auth Header                            |

### Tarefas

> Todos os endpoints abaixo requerem autenticação (Basic Auth).

| Método | Endpoint         | Descrição                | Body (JSON)                                  |
|--------|------------------|--------------------------|----------------------------------------------|
| GET    | `/task`          | Listar tarefas do usuário| —                                            |
| POST   | `/task/`         | Criar nova tarefa        | `{ "title": "...", "description": "...", "startAt": "2024-07-01T10:00:00", "endAt": "2024-07-01T12:00:00", "completed": false }` |
| PUT    | `/task/{id}`     | Atualizar tarefa         | (mesmo body do POST, campos opcionais)       |
| DELETE | `/task/{id}`     | Remover tarefa           | —                                            |

#### Exemplo de resposta de tarefa

```json
{
  "title": "Estudar Spring",
  "description": "Ler documentação oficial",
  "startAt": "2024-07-01T10:00:00",
  "endAt": "2024-07-01T12:00:00",
  "completed": false
}
```

## Swagger/OpenAPI

A documentação interativa está disponível em:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Autor

- Gustavo Penha  
- [gustavopenhadev@gmail.com](mailto:gustavopenhadev@gmail.com)  
- [https://github.com/gustavopenha07](https://github.com/gustavopenha07)