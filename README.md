# Food Delivery API

RESTful backend API for a Food Delivery Management System built with Spring Boot and PostgreSQL.

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA / Hibernate
- PostgreSQL 18
- Docker & Docker Compose
- Maven, Lombok, Jakarta Validation
- Swagger UI / OpenAPI 3

## Requirements

- JDK 21
- Maven
- Docker Desktop
- Git

## Database Setup

Start PostgreSQL and pgAdmin using Docker Compose:

```bash
docker compose up -d
```

**PostgreSQL Configuration**

- Database: `food_delivery_db`
- Username: `food_delivery_user`
- Password: `0000`
- Port: `5432`

**pgAdmin:** http://localhost:5050

Configure `src/main/resources/application.yaml`:

## Database Configuration

### Hibernate DDL Auto

After running the application for the first time, change the Hibernate DDL configuration from `create-drop` to `update`.

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: update
```

### Explanation

- `create-drop`: Creates the database schema when the application starts and drops it when the application shuts down.
- `update`: Attempts to update the database schema according to the entity mappings without recreating the entire schema.

**Important:** Back up your database before changing the configuration. Hibernate `update` does not guarantee that every schema change is handled safely.

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/food_delivery_db
    username: food_delivery_user
    password: ${DB_PASSWORD:0000}
```

## Installation

```bash
git clone https://github.com/sembunly/food_delivery_api.git
cd food_delivery_api
mvn clean install
mvn spring-boot:run
```

Application URL: http://localhost:8080

## API Documentation

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs