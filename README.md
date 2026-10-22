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

## Development

The project currently includes core entity models for users, devices, and notifications. Additional food delivery features and REST endpoints will be implemented incrementally.

## License

No license has been specified.
