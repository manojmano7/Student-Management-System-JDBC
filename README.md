# Student Management System

A console-based Student Management System developed using Core Java, JDBC, and MySQL. The project follows the DAO design pattern to separate database operations from application logic.

## Technologies Used

- Core Java
- JDBC (Java Database Connectivity)
- SQL
- MySQL
- Eclipse IDE
- JDK 21

## Features

- Student record management using CRUD operations
- Course record management
- Parent record management
- Database connectivity using JDBC
- SQL queries using `PreparedStatement`
- Stored procedure execution using `CallableStatement` for student search operations
- Centralized database connection management using Connection Factory

*Include only the features that are implemented and working in your project.*

## Design Patterns and Architecture

### 1. DAO (Data Access Object)
Provides interfaces for database operations and separates data access logic from the main application.

### 2. DAO Implementation
Implements database operations using JDBC and SQL queries.

### 3. DTO (Data Transfer Object)
Represents student, course, and parent data.

### 4. Connection Factory
Centralizes the creation of database connections.

## Project Structure

```text
student_management_system/
└── src/
    ├── connection/
    │   └── ConnectionFactory.java
    ├── dao/
    │   ├── CourseDAO.java
    │   ├── ParentDAO.java
    │   └── StudentDAO.java
    ├── daoimpl/
    │   ├── CourseDAOImpl.java
    │   ├── ParentDAOImpl.java
    │   └── StudentDAOImpl.java
    ├── dto/
    │   ├── Course.java
    │   ├── Parent.java
    │   └── student.java
    └── main/
        └── StudentManagement.java
```

## Prerequisites

- JDK 21
- Eclipse IDE
- MySQL Server
- MySQL Connector/J JDBC driver

## How to Run

1. Clone or download this repository.
2. Import the project into Eclipse as an existing Java project.
3. Create the required database and tables in MySQL.
4. Configure the database URL, username, and password in `ConnectionFactory.java`.
5. Add the MySQL JDBC driver to the project.
6. Create any required stored procedures in MySQL.
7. Run `StudentManagement.java` from the `main` package.

## Database Configuration

Update the connection details in `ConnectionFactory.java` to match your local MySQL setup.

**Security note:** Do not commit database passwords or other sensitive credentials to GitHub.

## Future Improvements

- Improve input validation and exception handling.
- Add more search and reporting options.
- Improve transaction management.
- Develop a graphical user interface.

---

**Project Type:** Java Database Application

**Author:** Manoj V.
