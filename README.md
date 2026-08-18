# BridgeLabz Backend Refresher Training

**Duration:** 31 July 2026 – 29 August 2026  
**Program:** Backend Refresher Training (Java)

## About This Repository

This repository contains my daily assignments, practice work, notes, and application development tasks completed during the BridgeLabz Backend Refresher Training Program.

---
## Training Coverage

| Phase | Topics |
|---------|---------|
| Database Programming | ☑ DBMS Fundamentals & RDBMS Basics<br>☑ ER Diagram, Indexing & Normalization<br>☑ Joins, Stored Procedures & Triggers<br>☑ JDBC & Health Clinic Application |
| Backend Fundamentals | ☑ Tomcat & Servlets<br>☑ Spring Framework Fundamentals<br>☑ Spring MVC<br>☑ REST APIs & Request Handling<br>☑ API Testing Tools & SDLC |
| Spring Boot Development | ☑ Spring Boot Fundamentals<br>☑ Dependency Injection & H2 Database<br>☑ Spring Services<br>☑ Spring JPA & Spring JDBC<br>☑ Logging, Maven & Postman |
| Advanced Backend Development | ☑ Spring Security & JWT Authentication<br>☐ Authorization & Notes Management<br>☐ Search, Filter & Tags Management<br>☐ JMS & Redis Caching<br>☐ RabbitMQ & Spring Batch<br>☐ Exception Handling, AOP & Spring Cloud |
| Microservices Architecture | ☐ Monolith vs Microservices<br>☐ API Gateway<br>☐ Service Registry (Eureka)<br>☐ Microservices Architecture & Integration |

---

## Repository Structure

```text
BridgeLabz-Training/
│
├── Day-1/
│   ├── day1_practice.sql
│   └── assignment.sql
│
├── Day-2/
│   ├── day2_assignment.sql
│   └── health_clinic_schema.sql
│   └── ER-Diagram.png
|
├── Day-3/
│   └── day3_practice.sql
|
├── Day-4/
│   └── HealthClinicApp/
|
├──Day-5/
|   └──MyGreetingApp/
|
├──Day-6/
|   └──MyGreetingApp/ (with CRUD)
|
├──Day-7/
|   └──ContactsApp/ 
|
├──Day-8/
|   └──ContactsApp/ (with CRUD)
|
├──Day-9/
|   └──CollegeManagementSystem/
|
├──Day-10/
|   └──EmployeePayrollApp/
|
├──Day-11/
|   └──EmployeePayrollApp/
|
├──Day-12/
|   └──EmployeePayrollApp/
|
├──Day-13/
|   └──FundooNotesApp/
|    
│
├── Day-/
│
├── ...
│
└── README.md
```

---

## Daily Activity Log

### Day 1 — 31-07-2026

## Focus Area - DBMS Fundamentals & RDBMS Basics

- Learned database fundamentals and DBMS architecture
- Understood the differences between File Systems, DBMS, and RDBMS
- Explored SQL vs NoSQL databases and their use cases
- Studied MySQL architecture and environment setup
- Practiced DDL and DML commands
- Installed and configured MySQL Server and MySQL Workbench
- Completed SQL practice exercises and assigned tasks

---

### Day 2 — 03-08-2026

## Focus Area - ER-Diagram, Indexing & Normalization

**Topics Covered**
- ER Diagram Fundamentals
- Entities, Attributes & Relationships
- Cardinality and Participation Constraints
- Primary Keys & Foreign Keys
- Database Normalization (1NF, 2NF, 3NF, BCNF)
- Indexing Concepts and B+ Tree Structure
- Clustered, Non-Clustered, Composite & Covering Indexes
- Query Optimization and Execution Plans

**Practiced**
- Designed and refined the Health Clinic database schema
- Implemented One-to-Many and Many-to-Many relationships
- Created `patient_phones` table to support multiple phone numbers
- Created `doctor_specializations` and `doctor_room` junction tables
- Added `rooms` table and mapped doctors to consultation rooms
- Applied normalization principles to eliminate redundancy
- Created single-column, composite, and covering indexes
- Analyzed query performance using `EXPLAIN`

---

### Day 3 — 04-08-2026

## Focus Area - SQL Joins, Stored Procedures & Triggers

**Topics Covered**
- SQL Join Operations
- INNER, LEFT, RIGHT, FULL OUTER, SELF & CROSS Joins
- Multi-Table Joins
- Stored Procedures
- IN, OUT & INOUT Parameters
- Transaction Management
- Error Handling in Procedures
- Database Triggers
- BEFORE and AFTER Triggers

**Practiced**
- Retrieved clinic data using different join operations
- Generated reports using multi-table joins
- Created stored procedures with parameter handling
- Implemented transaction control using COMMIT and ROLLBACK
- Added error handling using EXIT HANDLER
- Created triggers for data validation and activity logging
- Automated billing and visit history updates through triggers
- Enforced business rules and data integrity at the database level

---
### Day 4 — 05-08-2026

## Focus Area - JDBC & Health Clinic Console Application

**Topics Covered**
- JDBC fundamentals and database connectivity
- Maven project setup for Java applications
- MySQL connection handling using JDBC
- DAO design pattern for database operations
- DTO classes for transferring data
- Service layer for business logic
- HikariCP connection pooling
- Console-based interactive menu development

**Practiced**
- Created a complete Health Clinic Management Console App
- Connected Java application with MySQL database
- Implemented patient, doctor, specialization, appointment, billing, and visit history modules
- Added CRUD operations using DAO classes
- Used prepared statements for safer SQL execution
- Added appointment booking and cancellation features
- Implemented appointment completion with billing and visit history
- Organized the project using config, dao, dto, service, and ui packages
- Added a simple project README with setup and run instructions
#### The project structure is as follows: 
```
├── Day-4/
│   └── HealthClinicApp/
│       ├── database/
│       │   └── health_clinic_schema.sql
│       ├── src/main/java/com/clinic/
│       │   ├── config/
│       │   │   └── HikariConnectionPool.java
│       │   ├── dao/
│       │   │   ├── impl/
│       │   │   └── DAO interfaces
│       │   ├── dto/
│       │   │   └── Data model classes
│       │   ├── service/
│       │   │   └── AppointmentService.java
│       │   ├── ui/
│       │   │   └── ConsoleMenu.java
│       │   └── Main.java
│       ├── pom.xml
│       └── README.md

```
---

### Day 5 - 06-08-2026

## Focus Area - Spring MVC Fundamentals

**Topics Covered**
- Spring MVC Architecture
- Tomcat Servlet
- Spring IOC
- Dependency Injection
- Spring vs Spring Boot
- Model
- View
- Controller
- Request Lifecycle

**Practiced**
- Created `MyGreetingApp`, a beginner greeting web application
- Built an HTML form to accept the user's name
- Added `GreetingServlet` to handle form submission
- Used `request.getParameter()` to read form data
- Used request attributes to pass data from Servlet to JSP
- Used `greeting.jsp` as the view to display a personalized greeting
- Understood the MVC-style flow: Client Request -> Tomcat -> Servlet -> JSP -> Response
- Packaged the application as `MyGreetingApp.war` using Maven
- Added screenshots and setup instructions in `Day-5/README.md`

#### The project structure is as follows:
```
├── Day-5/
│   ├── README.md
│   ├── screenshots/
│   │   ├── home-page.png
│   │   └── old-result-page.png
│   └── MyGreetingApp/
│       ├── pom.xml
│       └── src/main/
│           ├── java/com/greetings/
│           │   └── GreetingServlet.java
│           └── webapp/
│               ├── index.html
│               ├── greeting.jsp
│               ├── css/styles.css
│               └── WEB-INF/web.xml
```

---

### Day-06: 07-08-26

## Focus Area - Spring MVC CRUD Application

**Topics Covered**
- Spring MVC Architecture
- Tomcat Servlet
- Spring IOC
- Dependency Injection
- Spring vs Spring Boot
- Model, View, and Controller
- DispatcherServlet
- Request Lifecycle

### Project: MyGreetingApp

Built a simple Spring Boot MVC CRUD application to manage greeting messages using Thymeleaf.

### Key Concepts Practiced

- **Spring MVC Architecture** - Follows the Model-View-Controller pattern to separate application logic.
- **DispatcherServlet** - Front controller that receives requests and routes them to the appropriate controller.
- **Controller (`@Controller`)** - Handles HTTP requests and prepares data for the view.
- **Views (Thymeleaf)** - Dynamic HTML templates used to render responses.
- **`@GetMapping`** - Maps HTTP GET requests to controller methods.
- **`@PostMapping`** - Maps form submissions to controller methods.
- **`@RequestParam`** - Retrieves form values from the request.
- **Model** - Passes data from the controller to the view.
- **Request Lifecycle** - Client Request -> DispatcherServlet -> Controller -> Model -> View -> Response.

### MyGreetingApp

- Created a Spring Boot MVC application named `MyGreetingApp`.
- Configured the application using `@SpringBootApplication`.
- Implemented `GreetingController` with:
  - `GET /` - Displays the add greeting form and greeting list.
  - `POST /greetings` - Saves a new greeting.
  - `GET /greetings/{id}` - Displays one greeting.
  - `GET /greetings/{id}/edit` - Opens the edit form.
  - `POST /greetings/{id}` - Updates an existing greeting.
  - `POST /greetings/{id}/delete` - Deletes a greeting.
- Used Thymeleaf templates to render dynamic content.
- Used an in-memory repository to store greeting records.
- Gained hands-on experience with the complete Spring MVC CRUD request flow.

#### Project Screenshots

**Home Page**

![MyGreetingApp home page](Day-06/MyGreetingApp/screenshots/home.png)

**Greeting Details Page**

![MyGreetingApp greeting details page](Day-06/MyGreetingApp/screenshots/greeting.png)

**Edit Greeting Page**

![MyGreetingApp edit greeting page](Day-06/MyGreetingApp/screenshots/edit%20greeting.png)

---

### Day 7 - 10-08-2026

## Focus Area - Spring REST API and Request Handling

**Topics Covered**
- Spring Boot REST API
- RESTful API request handling
- `@RestController`, `@RequestMapping`, `@PostMapping`, and `@RequestBody`
- Spring Data JPA and Hibernate
- Entity, Repository, Service, and Controller layers
- DTO Pattern
- H2 In-Memory Database
- H2 Database Console
- HikariCP Connection Pool

**Project: Contacts Management REST API**

Built a Contacts Management REST API using Spring Boot, Spring Data JPA, Hibernate, and H2 Database.

**Key Concepts Practiced**
- Implemented the Add Contact API using POST.
- Followed layered architecture: Controller -> Service -> Repository -> Database.
- Created `Contact` entity for database mapping.
- Used Request DTO and Response DTO for clean API data transfer.
- Configured H2 in-memory database and H2 Console.
- Used `JpaRepository` for database operations.
- Tested the API using Postman.

**API Implemented**
- `POST /contactApp/create` - Adds a new contact


#### The project structure is as follows:
```text
Day-7/
`-- ContactsApp/
    |-- pom.xml
    `-- src/
        |-- main/
        |   |-- java/
        |   |   `-- com/bridgelabz/contactsapp/
        |   |       |-- ContactsAppApplication.java
        |   |       |-- controller/
        |   |       |   `-- ContactAppController.java
        |   |       |-- dto/
        |   |       |   |-- ContactRequestDTO.java
        |   |       |   `-- ContactResponseDTO.java
        |   |       |-- model/
        |   |       |   `-- Contact.java
        |   |       |-- repository/
        |   |       |   `-- ContactRepository.java
        |   |       `-- service/
        |   |           `-- ContactService.java
        |   `-- resources/
        |       `-- application.properties
        `-- test/
            `-- java/com/bridgelabz/contactsapp/
                `-- ContactsAppApplicationTests.java
```

---


### Day 8 - 11-08-2026

## Focus Area - Spring Boot Contacts App Complete CRUD

**Topics Covered**
- Built a Contacts REST API using Spring Boot
- H2 Database integration with JPA/Hibernate
- DTO, Service, Repository and Controller layers
- Lombok and Builder Pattern
- Bean Validation and Exception Handling
- H2 Console integration
- Tested REST APIs using Postman

**Project: Contacts Management REST API**

Built a complete Contacts REST API using Spring Boot, Spring Data JPA, Hibernate, H2 Database, DTOs, validation, and exception handling.

**CRUD Operations**
- **Create** - Add a new contact with name, phone number and email.
- **Read** - Fetch all contacts or fetch a specific contact by ID.
- **Update** - Modify the details of an existing contact using its ID.
- **Delete** - Remove an existing contact using its ID.

**API Implemented**
- `POST /api/v1/contacts` - Adds a new contact
- `GET /api/v1/contacts` - Fetches all contacts
- `GET /api/v1/contacts/{id}` - Fetches a contact by ID
- `PUT /api/v1/contacts/{id}` - Updates an existing contact
- `DELETE /api/v1/contacts/{id}` - Deletes a contact


---

### Day 9 - 12-08-2026

## Focus Area - Spring Boot College Management System

**Project: College Management System**

Built a Spring Boot REST API to manage students and faculty records using MySQL, Spring Data JPA and layered architecture.

**Topics Covered**
- Spring Boot REST API with MySQL and JPA/Hibernate
- Entity, Repository, Service and Controller layers
- CRUD operations for Student and Faculty modules
- Custom JPA queries using `@Query`
- API testing using Postman

**APIs Implemented**
- `/api/students` - Create, read, update and delete student records
- `/api/faculty` - Create, read, update and delete faculty records
- `/api/faculty/highest-paid-by-department` - Highest paid faculty by department
- `/api/faculty/above-department-average` - Faculty above department average salary

---
### Day 10 - 13-08-2026

## Focus Area - Dependency Injection and H2 Database

**Topics Covered**
- Dependency Injection and IoC in Spring Boot
- Constructor, Field and Setter Injection
- Spring Bean creation and Component Scanning
- Circular Dependency and how to avoid it
- H2 in-memory database configuration
- H2 Console usage
- Basic JPA entity and repository setup

**Practiced**
- Created `EmployeePayrollApp`
- Configured H2 Database
- Created `Employee` entity
- Created `EmployeeRepository`
- Injected repository into controller using Constructor Injection
- Added basic APIs to save and fetch employees

**APIs Implemented**
- `POST /employees` - Add an employee
- `GET /employees` - Fetch all employees

---

### Day 11 - 14-08-2026

## Focus Area - Spring Services, Spring JPA & Spring JDBC

**Topics Covered**
- Spring REST API service-layer design
- Spring Data JPA repositories and entity mapping
- Spring JDBC and `JdbcTemplate` based data access
- Controller, Service and Repository responsibility split
- Difference between Entity and DTO
- Comparison of hand-written JDBC, `JdbcTemplate` and Spring Data JPA
- Rebuilding Employee Payroll App using Spring Data JPA and Spring JDBC

**Practiced**
- Built Employee Payroll App backend using Spring JPA and Spring JDBC.
- Created `Employee` entity and mapped it to the database table.
- Created `EmployeeRepository` using `JpaRepository`.
- Added service layer to keep business logic separate from controller logic.
- Used repository methods like `save()`, `findById()`, `findAll()` and `deleteById()`.
- Used `JdbcTemplate` where direct SQL access was required.
- Understood when to use JDBC, `JdbcTemplate` and Spring Data JPA.

**APIs Implemented**
- `POST /employees` - Add an employee
- `GET /employees` - Fetch all employees
- `GET /employees/count` - Count employee records using `JdbcTemplate`

---

### Day 12 - 17-08-2026

## Focus Area - Spring Bean Scopes, Logging, Maven and Postman

**Topics Covered**
- Spring Bean Scopes: singleton, prototype, request and session
- Logging in Spring Boot using SLF4J and Logback
- Maven dependency management
- Maven build lifecycle
- Postman API testing workflow
- Employee Payroll App backend completion

**Practiced**
- Continued the `EmployeePayrollApp`.
- Completed REST CRUD APIs for employee payroll records.
- Used Spring Data JPA repository for database operations.
- Used `JdbcTemplate` to count employee records.
- Added request and response DTOs for employee APIs.
- Added validation for required employee fields.
- Added duplicate email handling.
- Added custom exception handling for not found, bad request and duplicate email cases.
- Replaced console-style debugging with proper SLF4J logging.
- Configured logging levels in `application.properties`.

**APIs Implemented**
- `POST /employees` - Create employee
- `GET /employees` - Fetch all employees
- `GET /employees/{id}` - Fetch employee by ID
- `PUT /employees/{id}` - Update employee
- `DELETE /employees/{id}` - Delete employee
- `GET /employees/count` - Get employee count


---
## Day 13 - 18-08-2026

## Focus Area - Spring Security & JWT Authentication

**Topics Covered**

- Spring Security fundamentals and `SecurityFilterChain`
- Authentication and authorization in Spring Boot
- JWT (JSON Web Token) based authentication
- JWT generation and token-based authentication
- Password encryption using `BCryptPasswordEncoder`
- Securing endpoints using Spring Security
- Request validation using Jakarta Bean Validation
- Custom exception handling for authentication and registration errors

## Project : FundooNotesApp
**Practiced**
- Implemented user registration and login functionality for the Fundoo Notes App.
- Created `User` entity and persisted user details using Spring Data JPA.
- Created `UserRepository` using `JpaRepository`.
- Added `UserService` to handle user-related business logic.
- Implemented password encryption using `BCryptPasswordEncoder` instead of storing plain-text passwords.
- Implemented JWT token generation after successful authentication.
- Configured Spring Security to allow public access to registration and login endpoints.
- Added validation for registration and login request DTOs.
- Implemented duplicate email validation during user registration.
- Tested registration and login APIs using Postman.
- Verified JWT token generation and successful authentication flow.

**APIs Implemented**

- `POST /user/userSignUp` - Register a new user and generate JWT token
- `POST /user/login` - Authenticate user credentials and generate JWT token




## Maintained By

**Madhu Solanki**

Updated daily to reflect ongoing learning.
