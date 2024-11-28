# Role-Based-Access-Control

This project implements Role-Based Access Control (RBAC) using Spring Boot and MySQL. It handles user authentication and authorization based on roles like ADMIN and USER, ensuring secure access to specific endpoints.

## Overview
This project provides secure access to endpoints based on user roles (ADMIN and USER). The system ensures that only authorized users can access specific resources, demonstrating strong backend development skills in Spring Boot and security integration with **Spring Security**.

## Features

### 1. **Role Management**
- Users can be assigned roles (ADMIN, USER).
- Roles and permissions are stored in a relational database (MySQL).

### 2. **Secure Authentication**
- Implements **Basic Authentication**.
- Passwords are securely hashed using **BCrypt**.

### 3. **Access Control**
- Restricts access to endpoints based on roles:
  - `/admin/dashboard` - Restricted to **ADMIN** role.
  - `/user/dashboard` - Restricted to **USER** role.
  - `/` - Publicly accessible without authentication.

### 4. **REST API Endpoints**
- **Public Endpoint**: `/` (No authentication required)
- **Admin Endpoint**: `/admin/dashboard` (Restricted to **ADMIN** role)
- **User Endpoint**: `/user/dashboard` (Restricted to **USER** role)

### 5. **Database Integration**
- User and role data are stored and managed in a **MySQL** database.

## Technologies Used
- **Backend Framework**: Spring Boot 3.4.0
- **Database**: MySQL
- **Security**: Spring Security with Basic Authentication
- **Programming Language**: Java 17
- **Build Tool**: Maven

## Setup Instructions

### 1. Prerequisites
Before you start, ensure you have the following installed:
- **Java Development Kit (JDK)**: Version 17 or higher
- **Maven**: For building the project
- **MySQL**: For database management
- **Postman**: For API testing (optional but recommended)

### 2. Clone the Repository

git clone https://github.com/KothollaGanesh/Role-Based-Access-Control.git
cd Role-Based-Access-Control
### 3. Configure the Database
- **Create a MySQL database**:

sql
Copy code
CREATE DATABASE rbac_db;


### 3.1 Update the Database Configuration

In the `application.properties` file, update the following database configuration to connect the application to your MySQL database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rbac_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 4. Run the Application

To build and run the project using **Maven**, follow these steps:

1. **Build the Project**:


mvn clean install

mvn spring-boot:run
The application will start on http://localhost:8080.

## 4. Data Initialization

### 1. **Roles**
Insert roles into the roles table:

```sql
INSERT INTO roles (name) VALUES ('USER'), ('ADMIN');
```
### 2. **Users**
Insert users into the users table:

- **Admin User**:
  - **Username**: admin
  - **Password (hashed)**: `$2a$10$WGJ2svtPrDwPRJjASb38i.kosn2W4KNyxbI56cEsiZx5S6xMoT71q` (**plain**: admin123)

- **Regular User**:
  - **Username**: user
  - **Password (hashed)**: `$2a$10$IFlVb6OXdjoWI5ARdVoSf.jlGFtOKkPnTsFhBNFm4bLrKJzo8cusq` (**plain**: user123)

### 3. **User Roles**
Assign roles to users in the user_roles table:

- **SQL**:
  ```sql
  INSERT INTO user_roles (user_id, role_id) VALUES
  (1, 2), -- Admin
  (2, 1); -- User

Endpoints
### 1. **Public Endpoint**
- **Method**: GET
- **URL**: http://localhost:8080/
- **Access**: Public (no authentication required)
- **Response**:
  ```json
  "Welcome to the Home Page!"

### 2. **Admin Endpoint**
- **Method**: GET
- **URL**: http://localhost:8080/admin/dashboard
- **Access**: Restricted to ADMIN role
- **Authentication**: Basic Auth
  - **Username**: admin
  - **Password**: admin123
- **Response**:
  ```json
  "Welcome to the Admin Dashboard!"

### 3. **User Endpoint**
- **Method**: GET
- **URL**: http://localhost:8080/user/dashboard
- **Access**: Restricted to USER role
- **Authentication**: Basic Auth
  - **Username**: user
  - **Password**: user123
- **Response**:
  ```json
  "Welcome to the User Dashboard!"


### **Project Structure**

The project directory structure is as follows:

```plaintext
src/main/java/com/Assignment/demo/
- **config/**            # Security and application configurations
- **controller/**        # REST controllers for endpoints
- **entity/**            # Entity classes for User and Role
- **repository/**        # JPA repositories for database interaction
- **service/**           # Service layer for business logic
- **RBACApplication.java** # Main application class
```
### **Key Learnings**

- **Implemented Role-Based Access Control (RBAC)** using Spring Security.
- **Used BCryptPasswordEncoder** for secure password hashing.
- **Created and managed relational database schemas** with Spring Data JPA.
- **Tested APIs using Postman** for role-specific access control.

### **Conclusion**

In this project, I have implemented a **Role-Based Access Control (RBAC)** system using **Spring Boot** and **MySQL**. The system handles both **authentication** and **authorization** for users:

- **Authentication** ensures users are verified before accessing any resources.
- **Authorization** checks if the authenticated user has the correct role (e.g., ADMIN or USER) to access certain resources.

By using **Spring Security** and **MySQL**, I’ve created a secure application where users are assigned roles, and their access to different pages and actions is controlled based on those roles. This project demonstrates my ability to integrate **security features** into **backend development** and manage **user access** effectively.





