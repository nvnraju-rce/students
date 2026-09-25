# Student REST API - Spring Boot + Postman

A simple teaching project demonstrating REST Web Services, HTTP methods, Spring Boot, JPA/Hibernate and H2.

## Technology
- Java 17
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- H2 Database
- Postman

## Eclipse import
1. Extract the ZIP.
2. Eclipse -> File -> Import -> Maven -> Existing Maven Projects.
3. Select the extracted project folder.
4. Finish.
5. Right-click project -> Maven -> Update Project.
6. Run `StudentApiApplication.java` as Spring Boot App.

## Base URL
http://localhost:8080/api/students

## Postman examples

### 1. GET all students
GET http://localhost:8080/api/students

### 2. GET one student
GET http://localhost:8080/api/students/1

### 3. POST create student
POST http://localhost:8080/api/students
Header:
Content-Type: application/json

Body -> raw -> JSON:
{
  "name": "Ravi Kumar",
  "course": "B.Tech CSE",
  "email": "ravi@example.com"
}

### 4. PUT update student
PUT http://localhost:8080/api/students/1
Content-Type: application/json

{
  "name": "Ravi Kumar",
  "course": "M.Tech AI",
  "email": "ravi.updated@example.com"
}

### 5. DELETE student
DELETE http://localhost:8080/api/students/1

## Teaching flow

Postman
   |
   v
HTTP Request
   |
   v
@RestController
   |
   v
@Service
   |
   v
@Repository
   |
   v
JPA / Hibernate
   |
   v
H2 Database

Explain:
GET = Read
POST = Create
PUT = Update
DELETE = Delete

## H2 Console
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:studentdb
User: sa
Password: leave blank
