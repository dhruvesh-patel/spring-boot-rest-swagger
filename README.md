This repo demonstrates is spring boot REST API and demonstrates integration with swagger to document APIs. 

## Pre-requisite:
1) JDK 11
2) Eclipse / IntelliJ IDE 
3) Maven (if not part of IDE already)

## Steps to Setup :
1. Clone the application
https://github.com/dhruvesh-patel/spring-boot-rest-swagger.git

2. Go to src/main/resources/application.properties file and note H2 database user name & password. 
```
spring.datasource.username=XXXXX
spring.datasource.password=XXXXX
```

3. Build and run the app using IDE / maven
```
mvn clean install 
mvn spring-boot:run
The app will start running - check app health using http://localhost:8651/api/v1/health.
```

4. For in-memory H2 database console, Use this URL - http://localhost:8651/h2-console and below values (refer above point 2 for user name / password).

```
JDBC URL - jdbc:h2:mem:testdb
User name - xxxxx
Password - xxxxx
```

You can run below query and check USERS table is created with 5 rows in it (as we have defined data.sql under resources folder). 
select * from USERS;

5. To use Swagger UI, use this URL -  http://localhost:8651/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

6. Explore Rest APIs. This app defines following CRUD APIs.

```
GET /api/v1/users

GET /api/v1/users/{userId}

DELETE /api/v1/users/{userId}

POST /api/v1/users

Sample Post Request - 
{
  "id": 100,
  "firstName": "MS",
  "lastName": "Dhoni",
  "email": "ms.dhoni@bcci.com",
  "status": "ACTIVE",
  "createdBy": "SYSTEM",
  "updatedBy": "SYSTEM"
}

PUT /api/v1/users/{userId}

Sample Put Request - 

{
  "id": 5,
  "firstName": "Eoin",
  "lastName": "Morgan",
  "email": "eoin.morgan@ecb.com",
  "status": "ACTIVE",
  "createdBy": "SYSTEM",
  "updatedBy": "SYSTEM"
}
```
