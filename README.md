# Microservices Project – Order & Product Services

## Overview
This project demonstrates a simple **microservices architecture** built using **Spring Boot**.

The system contains four services:

- Product Service
- Order Service
- Eureka Server (Service Discovery)
- API Gateway

Each service runs independently and communicates through **REST APIs**.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL 
- Maven
- REST APIs
- Git and GitHub
- Eureka Server

---

## Services

### Product Service
Manages product information.

Features:
- Add product
- View all products
- Get product by ID
- Update product
- Delete product

Endpoints:

GET /products  
GET /products/{id}  
POST /products  
PUT /products/{id}  
DELETE /products/{id}

---

### Order Service
Manages customer orders.

Features:
- Create order
- View all orders
- Get order by ID
- Update order
- Delete order

Endpoints:

GET /orders  
GET /orders/{id}  
POST /orders  
PUT /orders/{id}  
DELETE /orders/{id}

---

## How to Run the Project

### 1. Clone the Repository

git clone https://github.com/sabari29404/microservices-project.git

### 2. Open in IDE
Import the project as a **Maven project** in IntelliJ, Eclipse, or VS Code.

### 3. Configure Database
Update the `application.properties` file if using MySQL.

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database  
spring.datasource.username=root  
spring.datasource.password=your_password  

You can also use **H2 database** for testing.

### 4. Run the Services

Run each service using:

mvn spring-boot:run

---

## API Testing

You can test the APIs using:

- Postman
- Browser (for GET requests)

---

## Future Improvements

- Add JWT authentication
- Dockerize the services
- Add centralized logging

---

## Author

Sabari  
Java Backend Developer (Fresher)
