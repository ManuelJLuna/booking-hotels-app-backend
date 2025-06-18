# Booking Hotels App (Backend)

This is the backend of the Booking Hotels App — a RESTful API built with Spring Boot. It provides endpoints for managing hotels, reservations, and user reviews.

Frontend repository: [booking-hotels-app](https://github.com/ManuelJLuna/booking-hotels-app)

## Features

- Create, read, update, and delete hotels
- Create and retrieve hotel reservations
- Submit and fetch hotel reviews
- Store hotel photos
- Filter hotels by location
- Auto-generated API documentation

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 in-memory database
- Spring Web
- SpringDoc OpenAPI (Swagger UI)

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ManuelJLuna/booking-hotels-app-backend.git
cd booking-hotels-app-backend
```

### 2. Build and run the application

You can run it using your IDE or with the following command:

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Documentation

Once the application is running, the interactive documentation is available at:

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## Sample Endpoints

- `GET /hotel` - List all hotels
- `GET /hotel/{id}` - Get hotel
- `POST /hotel` - Create a new hotel
- `POST /reservation` - Make a reservation
- `GET /reservation/{id}` - Get a reservation
- `POST /review` - Submit a hotel review

## Database Configuration

This project uses an in-memory H2 database. You can view the database console at:

```
http://localhost:8080/h2-console
```

Make sure to set the JDBC URL to `jdbc:h2:mem:testdb` in the console.

## Project Structure

```
src/main/java/com/dh/proyectoAPI/
├── controller/         # REST controllers
├── entity/             # JPA entities
├── repository/         # Spring Data repositories
├── service/            # Service layer interfaces and implementations
└── ProyectoApiApplication.java  # Main Spring Boot application
```

## License

This project is open-source and is distributed under the MIT License.

## Author

Created by Manu Luna — [GitHub Profile](https://github.com/ManuelJLuna)