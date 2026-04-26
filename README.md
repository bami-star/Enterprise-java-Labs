//Enterprise-java-Labs
//Enterprise Application Development Labs
//Spring Boot REST API Projects - Product Management System

Name: Beamlak Tibebu  
Student ID: ATE/3624/14  



//Project Overview
This repository contains the implementation of Enterprise Java Labs, focusing on building scalable RESTful web services. The project utilizes Spring Boot, JPA/Hibernate for data persistence, and an H2 In-Memory Database.

//Lab Implementations

//Lab 1: Foundation
* Initialized Maven project structure.
* Established basic REST Controllers and DTOs.
* Configured local environment and Spring Boot starter dependencies.

//Lab 2: CRUD & Error Handling
* JPA/Hibernate: Integrated database persistence for Product entities.
* Service Layer: Implemented clean separation of concerns between Controller and Repository.
* Global Exception Handling: Custom ResourceNotFoundException handling (Verified 404 response logic).
* API Documentation: Integrated Swagger UI for interactive testing.

// How to Run the Project
mvn spring-boot: run, then the server will start on http://localhost:8080

//How to Test
1. Swagger UI is Best for testing. I used this.
Open the browser and navigate to:
http://localhost:8080/swagger-ui/index.html

2. Verified Test Cases
• POST /products: Create a new product (e.g., Tablet, Price: 500).
• Result: 201 Created - Confirms JPA and logic are working.
• GET /products/{id}: Retrieve a product by ID.
• Result (ID 999): 404 Not Found - Confirms Custom Exception Handling is working.
• GET /products: List all products.
• Result: 200 OK - Confirms Dependency Injection and Service layer are working.

//Technologies Used
• Java 17+
• Spring Boot 3.5.13 (Web, Data JPA)
• H2 Database
• Maven
• Swagger/OpenAPI
