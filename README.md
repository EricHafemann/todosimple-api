# 📌 TodoSimple API

API REST desenvolvida com Spring Boot para gerenciamento de usuários e tarefas (Todo List).

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 📂 Estrutura do Projeto

```
src/main/java/com/project/todosimple
│
├── config
├── controllers
├── exceptions
├── models
├── repositories
├── services
└── TodosimpleApplication
```

---

## 📌 Funcionalidades

- ✅ Cadastro de usuários
- ✅ Listagem de usuários
- ✅ Busca de usuário por ID
- ✅ Criação de tarefas
- ✅ Listagem de tarefas por usuário
- ✅ Tratamento global de exceções

---


## 🌐 Endpoints de Exemplo

### 🔹 Teste da API
```
GET /api/test
```

### 🔹 Usuários
```
GET    /users
POST   /users
GET    /users/{id}
PUT    /users/{id}
DELETE /users/{id}
```

### 🔹 Tarefas
```
GET    /tasks
POST   /tasks
GET    /tasks/user/{userId}
PUT    /tasks/{id}
DELETE /tasks/{id}
```

---

## 📄 Licença

Este projeto é para fins de estudo.
