# Food Delivery API

RESTful backend API for a Food Delivery Management System built with Spring Boot, Spring Data JPA, and PostgreSQL.

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Lombok
- Jakarta Validation
- Swagger UI / OpenAPI 3

## Requirements

- JDK 21
- Maven
- PostgreSQL
- Git

## Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE food_delivery_db;
```

Configure `src/main/resources/application.yaml`:

```yaml
server:
  port: 8080

spring:
  application:
    name: food_delivery_api

  datasource:
    url: jdbc:postgresql://localhost:5432/food_delivery_db
    username: postgres
    password: ${DB_PASSWORD}

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

Set the `DB_PASSWORD` environment variable before starting the application.

## Installation

Clone the repository:

```bash
git clone https://github.com/sembunly/food_delivery_api.git
cd food_delivery_api
```

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Application URL:

`http://localhost:8080`

## API Documentation

Swagger UI (when Springdoc is configured):

`http://localhost:8080/swagger-ui.html`

OpenAPI JSON:

`http://localhost:8080/v3/api-docs`

