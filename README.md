# 📌 TodoSimple API

API REST desenvolvida com **Spring Boot** para gerenciamento de usuários e tarefas (Todo List), seguindo princípios de **Domain-Driven Design (DDD)** com separação clara de responsabilidades.

---

## 🚀 Tecnologias Utilizadas

* **Java 24**
* **Spring Boot 3.5.11**
* **Spring Data JPA** & **Hibernate**
* **MySQL**
* **Maven**
* **SpringDoc OpenAPI (Swagger)**
* **Bean Validation**

---

## 📂 Estrutura do Projeto (DDD)

A organização segue os padrões de domínio, aplicação e infraestrutura para garantir baixo acoplamento:

```text
src/main/java/com/project/todosimple
│
├── application
│   ├── controllers         # TaskController, UserController
│   ├── dtos                # TaskCreateDTO, UserResponseDTO, etc.
│   └── services            # DTOMapper, TaskApplicationService, UserApplicationService
│
├── domain
│   ├── entities            # Task, User
│   ├── exceptions          # DomainException, TaskNotFoundException, etc.
│   ├── repositories        # TaskRepository, UserRepository (Interfaces)
│   └── services            # TaskDomainService, UserDomainService
│
└── infrastructure
    └── persistence         # SpringData repositories e implementações (TaskRepositoryImpl)
```

---

## ✅ Funcionalidades

- [x] **Cadastro de usuários**: Criação, atualização, busca por ID e remoção.
- [x] **Gestão de tarefas**: Criação de tarefas vinculadas a usuários e listagem por ID.
- [x] **Listagem específica**: Busca de todas as tarefas associadas a um determinado ID de usuário.
- [x] **Tratamento Global de Exceções**: Handler que retorna erros padronizados em JSON.
- [x] **Validações de Negócio**: Implementação de limites de tarefas e validação de descrição mínima.
- [x] **Arquitetura Limpa**: Separação rigorosa de responsabilidades utilizando o padrão DDD.

---

## 🌐 Endpoints da API

### 🧑‍💻 Usuários

| Método | Rota | Descrição | Entrada (Request) | Saída (Response) |
| :--- | :--- | :--- | :--- | :--- |
| 🟢 **GET** | `/user/{id}` | Busca usuário por ID | - | `UserResponseDTO` |
| 🔵 **POST** | `/user` | Cria um novo usuário | `UserCreateDTO` | `UserResponseDTO` |
| 🟠 **PUT** | `/user/{id}` | Atualiza dados do usuário | `UserUpdateDTO` | `UserResponseDTO` |
| 🔴 **DELETE**| `/user/{id}` | Remove um usuário | - | `204 No Content` |

<details>
<summary><b>👀 Ver exemplo de requisição (POST /user)</b></summary>

```json
{
  "username": "joao.silva",
  "password": "123456"
}
```
</details>

<br>

### 📋 Tarefas

| Método | Rota | Descrição | Entrada (Request) | Saída (Response) |
| :--- | :--- | :--- | :--- | :--- |
| 🟢 **GET** | `/task/{id}` | Busca tarefa por ID | - | `TaskResponseDTO` |
| 🟢 **GET** | `/task/user/{userId}` | Lista tarefas de um usuário | - | `List<TaskSummaryDTO>` |
| 🔵 **POST** | `/task` | Cria uma nova tarefa | `TaskCreateDTO` | `TaskResponseDTO` |
| 🔴 **DELETE**| `/task/{id}` | Remove uma tarefa | - | `204 No Content` |

<details>
<summary><b>👀 Ver exemplo de resposta (GET /task/1)</b></summary>

```json
{
  "id": 1,
  "description": "Estudar Spring Boot",
  "user": {
    "id": 1,
    "username": "joao.silva"
  }
}
```
</details>

## ⚠️ Tratamento de Erros

A API utiliza um handler global que retorna respostas estruturadas:

```json
{
  "status": 404,
  "message": "Tarefa não encontrada: 999",
  "timestamp": 1704405600000,
  "path": "/task/999"
}
```

| Código | Descrição |
| :--- | :--- |
| **200** | OK - Requisição bem-sucedida. |
| **201** | Created - Recurso criado com sucesso. |
| **204** | No Content - Recurso removido com sucesso. |
| **400** | Bad Request - Erro de validação nos dados. |
| **404** | Not Found - Recurso não encontrado. |
| **409** | Conflict - Violação de regra de negócio. |
| **500** | Internal Server Error - Erro interno. |

---

## 📖 Documentação com Swagger

Após iniciar a aplicação, acesse a documentação interativa:
👉 `http://localhost:8080/swagger-ui.html`

---

## 📄 Licença
Este projeto é para fins de estudo.
