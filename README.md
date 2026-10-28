# Spring Fundamentals – Beer & Customer REST API

A Spring Boot REST API for managing beers and customers, built to practice Spring fundamentals: dependency injection, REST controllers, Spring Data JPA, MapStruct mapping, validation and testing with MockMvc.

## Tech Stack

- Java 17, Spring Boot 3.1
- Spring Web, Spring Data JPA (Hibernate)
- H2 (default, in-memory) and MySQL (`localmysql` profile)
- MapStruct, Lombok, Bean Validation
- JUnit 5, Mockito, MockMvc

## Features

- Beer API: list, get by id, create (validated), update, delete — backed by JPA
- Customer API: list and get by id backed by JPA
- 404 responses for unknown ids, 400 with field errors for invalid beer payloads
- In-memory implementations of both services (`BeerServiceImpl`, `CustomerServiceImpl`) used in the controller unit tests

Work in progress: beer PATCH and customer create/update/patch/delete are not implemented in the JPA services yet.

## Getting Started

### Prerequisites

- JDK 17
- MySQL (only for the `localmysql` profile)

### Run with H2 (default)

```bash
git clone https://github.com/Hussein-Fouani/Spring_Fundamentals_Project.git
cd Spring_Fundamentals_Project
./mvnw spring-boot:run
```

The API runs on `http://localhost:8080`.

### Run with MySQL

Create the database and user with `src/main/java/scripts/sql-init.sql`, or create a `restdb` database yourself. Connection settings are in `src/main/resources/application-localmysql.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/restdb
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:root}
```

Set `DB_USERNAME` and `DB_PASSWORD` to override the defaults, then start with the profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=localmysql
```

## API Endpoints

### Beers

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/v1/beer` | List beers |
| GET | `/api/v1/beer/{beerId}` | Get a beer |
| POST | `/api/v1/beer` | Create a beer (returns `Location` header) |
| PUT | `/api/v1/beer/{beerId}` | Update a beer |
| DELETE | `/api/v1/beer/{beerId}` | Delete a beer |

Beer body:

```json
{ "beerName": "Galaxy Cat", "beerStyle": "PALE_ALE", "upc": "12356", "price": 12.99, "quantityOnHand": 122 }
```

`beerStyle` is one of `LAGER, PILSNER, STOUT, GOSE, PORTER, ALE, WHEAT, IPA, PALE_ALE, SAISON`.

### Customers

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/v1/customer` | List customers |
| GET | `/api/v1/customer/{customerId}` | Get a customer |

## Tests

```bash
./mvnw test
```
