# **Java Backend Interview Assignment**

## **Project Description**
This project is a Java Spring Boot application designed to demonstrate key backend development skills, including RESTful API creation, database integration, logging, and pagination. The application includes features like logging request/response details, transactional operations, and integration with a third-party API.

---

## **Features**
1. **API for Client**: 
   - APIs to perform CRUD operations with logging.
   - Postman collection provided for testing.

2. **Database Integration**:
   - Connected to MSSQL database (DB name: `TESTDB`).

3. **Transactional Methods**:
   - `@Transactional` annotation used for `INSERT`, `UPDATE`, and `GET` methods.

4. **Pagination**:
   - One GET API supports pagination (10 records per page).

5. **Nested API Calls**:
   - An API that calls another third-party API.

---

## **Technologies Used**
- Java 8
- Spring Boot
- MSSQL Database
- Hibernate/JPA
- SLF4J for logging
- Maven for dependency management
- Postman for API testing

---

## **Setup Instructions**
### **Prerequisites**
- Java 8 installed.
- MSSQL Server running on the local machine.
- Postman installed for API testing.

### **Database Setup**
1. Ensure MSSQL is running locally.
2. Create a database named `TESTDB`.
3. Update `application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=TESTDB;encrypt=false;trustServerCertificate=true;
   spring.datasource.username=sa
   spring.datasource.password=YourPassword
   spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
   spring.jpa.hibernate.ddl-auto=update

## **Endpoints**
### **User APIs**
| Method | Endpoint        | Description               |
|--------|------------------|---------------------------|
| POST   | `/api/users`     | Create a new user         |
| GET    | `/api/users/{id}`| Get a user by ID          |
| GET    | `/api/users`     | Get paginated users (10/page) |
| PUT    | `/api/users/{id}`| Update a user by ID       |

### **Third-Party API Integration**

| Method | Endpoint         | Description              |
|--------|-------------------|--------------------------|
| GET    | `/api/external`   | Call a third-party API   |


## Logging
- All request and response details are logged into the file: `logs/users.log`.
- The log includes detailed information about the API interactions.

## Postman Collection
- A Postman collection is provided to facilitate testing of the APIs.
- File name: `postman_collection.json`.

## Project Structure

| Directory/File         | Description                                      |
|-------------------------|--------------------------------------------------|
| `src/main/java/com/maybank/assessment`         | Contains the main Java source files for the application. |
| `src/main/resources`    | Holds application configuration files such as `application.properties`. |
| `src/main/java/com/maybank/assessment/controller` | Contains the REST controllers for API endpoints. |
| `src/main/java/com/maybank/assessment/service`    | Includes the service layer for business logic. |
| `src/main/java/com/maybank/assessment/repository` | Contains the repository layer for database interactions. |
| `src/main/java/com/maybank/assessment/entity`     | Defines the database entity classes. |
| `src/main/java/com/maybank/assessment/dto`        | Contains Data Transfer Object (DTO) classes. |
| `src/test/java`         | Contains the test cases for the application. |
| `logs`                  | Directory where log files are stored. |
| `pom.xml`               | Maven configuration file for managing dependencies. |
