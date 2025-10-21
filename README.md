# Task Manager - Spring Boot + MySQL

A simple REST API built with Spring Boot and MySQL that allows users to register, log in, and manage their daily tasks.  
This project demonstrates basic CRUD operations, RESTful endpoints, and database connectivity.

## 🚀 Features
- User registration and login
- Create, update, delete, and view tasks
- Filter tasks by status (pending/completed)
- Connects to MySQL database using JPA
- REST API tested with Postman


## 🛠️ Tech Stack
- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- MySQL  
- Maven  
- Postman (for API testing)


## Update application.properties
- spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
- spring.datasource.username=your_username
- spring.datasource.password=your_password
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

##Test APIs using Postman
## 🌐 API Endpoints

| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/api/users/register` | Register a new user |
| POST | `/api/users/login` | Login existing user |
| POST | `/api/tasks?userId={id}` | Create new task for user |
| GET | `/api/tasks?userId={id}` | Get all tasks for user |
| PUT | `/api/tasks/{id}` | Update existing task |
| DELETE | `/api/tasks/{id}` | Delete task |


##Example JSON for Postman
## 🧪 Example JSON (for Postman)

### Register User
POST `/api/users/register`
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "12345"
}

## 📁 Folder Structure

src/
 └── main/
     ├── java/com/example/taskmanager/
     │   ├── controller/
     │   ├── model/
     │   ├── repository/
     │   ├── service/
     │   └── TaskManagerApplication.java
     └── resources/
         ├── application.properties
pom.xml



