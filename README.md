# Mutual Fund Investment Tracker (Spring Boot + Postman)

A simple **Mutual Fund Investment Tracker** built with **Spring Boot** to manage mutual fund holdings and track investments. The APIs are tested using **Postman**.

---

## Features
- Manage mutual fund details (name, NAV, etc.)
- Record investments (units, purchase date, cost)
- Track holdings and investment performance
- REST APIs tested end-to-end using **Postman**

---

## Tech Stack
- **Java**
- **Spring Boot**
- **Spring Data JPA** (typical for persistence)
- **H2/MySQL/PostgreSQL** (depending on your config)
- **Postman** for API testing

---

## Project Setup

### 1) Prerequisites
- Java 17 (or compatible version)
- Maven/Gradle
- Postman
- Database (if not using H2)

### 2) Clone / Open Project
```bash
git clone <repo-url>
cd <project-folder>
```

### 3) Configure Application
Update `src/main/resources/application.properties` (example):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/databasename
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

> If using MySQL/PostgreSQL, replace the datasource properties accordingly.

---

## How to Run
```bash
mvn spring-boot:run
```

Server typically starts on:
- `http://localhost:8080`

---

## API Documentation (Postman)

Below is a suggested set of endpoints you can use for Postman.  
(Replace endpoint paths if your project uses different naming.)

### 1) Health Check
- **GET** `/api/health`
- Response example:
```json
{
  "status": "UP"
}
```

### 2) Mutual Funds
- **POST** `/api/mutual-funds`
  - Request:
```json
{
  "name": "Nifty 50 Index Fund",
  "category": "Index",
  "isin": "INF000123456"
}
```

- **GET** `/api/mutual-funds`
- Response example:
```json
[
  {
    "id": 1,
    "name": "Nifty 50 Index Fund",
    "category": "Index",
    "isin": "INF000123456"
  }
]
```

- **GET** `/api/mutual-funds/{id}`

- **PUT** `/api/mutual-funds/{id}`
- **DELETE** `/api/mutual-funds/{id}`

### 3) Investments
- **POST** `/api/investments`
  - Request:
```json
{
  "mutualFundId": 1,
  "units": 10.5,
  "purchasePrice": 235.50,
  "purchaseDate": "2025-01-15"
}
```

- **GET** `/api/investments`
- Response example:
```json
[
  {
    "id": 1,
    "mutualFundId": 1,
    "units": 10.5,
    "purchasePrice": 235.5,
    "purchaseDate": "2025-01-15"
  }
]
```

- **GET** `/api/investments/{id}`
- **DELETE** `/api/investments/{id}`

### 4) Holding Summary / Portfolio
- **GET** `/api/portfolio/summary`
- Response example:
```json
{
  "totalInvested": 2472.75,
  "totalUnits": 10.5,
  "funds": [
    {
      "mutualFundId": 1,
      "name": "Nifty 50 Index Fund",
      "units": 10.5,
      "investedAmount": 2472.75
    }
  ]
}
```

---

## Postman Collection (Recommended)
Create a Postman collection with:
- Base URL: `http://localhost:8080`
- Folders:
  - `Mutual Funds`
  - `Investments`
  - `Portfolio`
- Add requests for each endpoint listed above.

---

## Folder Structure (Typical)
```text
src/main/java
  └── com.yourcompany.mutualfundtracker
      ├── controller
      ├── service
      ├── repository
      ├── model/entity
      └── MutualFundTrackerApplication.java
```
## Testing Notes
- Use Postman to validate:
  - Correct status codes (`200/201/400/404`)
  - Response JSON schema
  - CRUD operations
- If you have automated tests (JUnit), run:
```bash
mvn test
```

## Future Enhancements
- Add user authentication (JWT)
- Track SIP (Systematic Investment Plans)
- Add NAV update service and historical NAV charts
- Add pagination/filtering for lists
