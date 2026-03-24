# REST-API

A simple Spring Boot REST API for managing student records using MySQL and Spring Data JPA.

## Overview

This project provides CRUD operations for students:

- Create a student
- Get all students
- Get a student by ID
- Update a student
- Delete a student

Base API path:

- `/api/students`

## Tech Stack

- Java 21
- Spring Boot 4.0.3
- Spring Web MVC
- Spring Data JPA
- MySQL
- Maven

## Project Structure

```text
src/main/java/com/sample/REST_API
├── Controller
│   └── StudentController.java
├── Model
│   └── Student.java
├── Repository
│   └── StudentRepository.java
├── Service
│   └── StudentService.java
└── RestApiApplication.java
```

## Prerequisites

Install and configure:

- Java 21 or later
- Maven 3.9+ (or use `./mvnw`)
- MySQL 8+

## Database Setup

1. Start MySQL.
2. Create the database:

```sql
CREATE DATABASE College;
```

3. Configure your DB settings in `src/main/resources/application.properties`.

Current keys used by the app:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/College
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
server.port=8080
```

Note: avoid committing real database passwords in source control.

## Run the Application

From project root:

```bash
# macOS/Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

The API will run on:

- `http://localhost:8080`

## API Endpoints

### 1. Get All Students

- Method: `GET`
- URL: `/api/students`

```bash
curl -X GET http://localhost:8080/api/students
```

### 2. Get Student By ID

- Method: `GET`
- URL: `/api/students/{id}`

```bash
curl -X GET http://localhost:8080/api/students/1
```

### 3. Create Student

- Method: `POST`
- URL: `/api/students`

```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "Rishu",
    "course": "Computer Science"
  }'
```

### 4. Update Student

- Method: `PUT`
- URL: `/api/students/{id}`

```bash
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "Rishu Raj",
    "course": "Software Engineering"
  }'
```

### 5. Delete Student

- Method: `DELETE`
- URL: `/api/students/{id}`

```bash
curl -X DELETE http://localhost:8080/api/students/1
```

## Student JSON Model

```json
{
  "id": 1,
  "name": "Rishu",
  "course": "Computer Science"
}
```

## Running Tests

```bash
# macOS/Linux
./mvnw test

# Windows
mvnw.cmd test
```

## Common Issues

- **Cannot connect to MySQL**
  - Check MySQL service is running.
  - Verify DB name, username, and password.
  - Ensure port `3306` is available.

- **Port 8080 already in use**
  - Change `server.port` in `application.properties`.

## Future Improvements

- Add validation and exception handling with proper HTTP status codes.
- Add DTOs and mapping layer.
- Add Swagger/OpenAPI documentation.
- Add unit and integration tests for controller and service layers.
