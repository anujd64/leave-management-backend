# Leave Management System - Backend

This Leave Management System Backend is developed in Java using Spring Boot framework. It provides functionalities for managing employee leaves efficiently. The system utilizes JWT token for authentication and MySQL database to store employee information.

## Features

- Authentication using JWT token
- MySQL database for storing data
- CRUD operations for the following entities:
    - Employee
    - Leave Request
    - Leave Request Type
    - Department
    - Login Request
    - Login Response
    - Company Holiday
- Controllers for handling various operations:
    - Auth
    - CompanyHoliday
    - Department
    - Employee
    - LeaveRequest
    - LeaveType
- Spring Security for protecting most endpoints from unauthorized access
- Lombok used to generate class constructors, getters, and setters

## Technologies Used

- Java
- Spring Boot
- JWT (JSON Web Token)
- MySQL
- Lombok

## API Endpoints

<img src="./Screenshots/1.png?raw=true" style="width: 100%;margin:16px;" />&nbsp;&nbsp;
<img src="./Screenshots/2.png?raw=true" style="width: 100%;margin:16px;" />&nbsp;&nbsp;
<img src="./Screenshots/2.png?raw=true" style="width: 100%;margin:16px;" />&nbsp;&nbsp;

## Authentication

- The majority of endpoints are protected from unauthorized access using Spring Security.
- To access protected endpoints, include the JWT token obtained after successful login in the Authorization header of your HTTP requests.
