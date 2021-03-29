# Contact-regex Application [![Build Status](https://travis-ci.org/AleksandrPok/Contact-regex.svg?branch=main)](https://travis-ci.org/AleksandrPok/Contact-regex)

This application returns a list of contacts that do not match the passed regular expression.

## Running the Application

1. Download and install JDK;
2. Download and install MySQL Server;
3. Setup connection properties in `application.properties` file:
   - `spring.datasource.url=jdbc:mysql://localhost/your_db_name`
   - `spring.datasource.username=your username`
   - `spring.datasource.password=your password`
    
#### OR

1. Download and install Docker
2. Run next commands in terminal from contact-regex directory:

 `mvn clean package`

 `docker-compose up`

You can send request with your regex and get all contacts that don't match with it:

`http://localhost:8082/hello/contacts?nameFilter=your_regex`