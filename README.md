# Healthcare Microservices – Secure Authentication System

This project is a **production-style Spring Boot microservices authentication service** implementing:

- User Registration & Login
- BCrypt Password Encryption
- JWT Token-based Authentication
- Stateless Spring Security Configuration
- Protected REST APIs
- MySQL Database Integration

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security 6
- JWT (jjwt)
- MySQL
- Maven

---

## Features

### Authentication
- Secure user registration
- Password hashing using BCrypt
- Login validation with encrypted passwords
- JWT token generation after successful login

### Authorization
- Stateless authentication using JWT
- Custom JWT filter in Spring Security
- Protected API endpoints requiring Bearer token

---

## API Endpoints

### Register User
POST /api/auth/register


### Login
POST /api/auth/login

Returns **JWT token**.

### Protected Test API
GET /api/test

Requires:
Authorization: Bearer <token>


---

## How to Run

1. Clone repository
2. Create MySQL database:
```sql
CREATE DATABASE auth_db;
Update application.properties

Run Spring Boot:

mvn spring-boot:run
Project Architecture
Controller → Service → Repository → Database
JWT Filter → Spring Security → Protected APIs

Future Enhancements
API Gateway (Spring Cloud Gateway)

Docker containerization

Role-based authorization (ADMIN/USER)

Refresh tokens

Full healthcare domain microservices

Author
Sai Kumar M
Java Full Stack Developer
Focus: Spring Boot • Microservices • Cloud • Security
