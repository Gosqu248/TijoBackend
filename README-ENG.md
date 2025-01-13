# 📘 Software Testing and Quality

## ✍️ Author
**Grzegorz Urban**

## 🎯 Project Topic
**Testing an Application for Ordering from Different Restaurants**

## 📄 Project Description
The project involves testing a web application that allows users to:

- Search for nearby restaurants based on a given address.
- Order food online from selected restaurants.

The goal of the project is to ensure that the search and ordering functions work correctly and without errors, providing the best user experience.

## Running the Project

### Server-side Application - Backend (Spring Boot)
- mvn spring-boot:run
### Web Application - Frontend (Angular)
- npm install
- ng serve

The web application is located in a separate repository, available through this [link](https://github.com/Gosqu248/TijoFrontend).

## ✅ Tests
In the project, unit tests, integration tests, and test cases for manual testing were conducted. All tests were successful.

### Test Scope:

- **Unit Tests** – 14 tests were conducted to check the correctness of individual components of the application, such as address search and restaurant display. The unit tests are available under this [link](https://github.com/Gosqu248/TijoBackend/tree/main/src/test/java/pl/urban/tijobackend/unitTests).

- **Integration Tests** – 12 tests were conducted to check the proper interaction between modules responsible for searching and placing orders. The integration tests can be found under this [link](https://github.com/Gosqu248/TijoBackend/tree/main/src/test/java/pl/urban/tijobackend/integrationTests).

- **Test Cases for Manual Testers** – 11 test cases were prepared, which are thoroughly described and can be executed by manual testers. Detailed test cases can be found under this [link](https://github.com/Gosqu248/TijoBackend/blob/main/TestCase.md).

## API Documentation

The API documentation is available in Swagger UI. To view it, start the server and navigate to the following link:

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/).

Below are screenshots from the Swagger UI API documentation:

![image](https://github.com/user-attachments/assets/a1404965-70f8-4e2e-8a42-9c38bec4cb0e)

![image](https://github.com/user-attachments/assets/e789f508-4b68-41a6-9080-6fca03e80d2d)

## Technologies Used in the Project

- **Spring Boot** – a framework for building web applications in Java.
- **Angular** – a front-end framework for building dynamic web applications.
- **PostgreSQL** – a relational database management system.
- **Swagger UI** – a tool for generating interactive API documentation.
- **JUnit 5** – a framework for writing unit tests in Java.
- **MockMvc** – a tool for testing controllers in Spring applications.
- **Mockito** – a library for mocking objects in unit tests.
- **Angular Material** – UI components based on Material Design for Angular applications.
- **AssertJ** – a library for writing more expressive and readable assertions in tests.

---

Thanks to the conducted tests, it was ensured that the key features of the application work as expected and meet the users' requirements.
