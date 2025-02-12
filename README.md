
# LibTi-back

API em Spring Boot para o back-end da aplicação LibTi

## Tecnologias 

- Java 23
- Spring Boot
- MySQL
- Maven

## Instalação e Configuração

### Pré-requisitos

- JDK 23+
- Maven 
- Banco de dados configurado 

### Passos para rodar o projeto

```sh
# Clone o repositório
git clone https://github.com/Aerttyz/libti-back.git
cd seu-repositorio

# Configurar variáveis de ambiente ou application.properties
# Exemplo:
# src/main/resources/application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
# spring.datasource.username=usuario
# spring.datasource.password=senha

# Compilar e executar
mvn spring-boot:run
```

## Endpoints

### Autenticação 

`POST /auth/login`

- Request Body:
  ```json
  {
    "username": "usuario",
    "password": "senha"
  }
  ```
- Response:
  ```json
  {
    "token": "jwt-token"
  }
  ```



