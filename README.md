# Hotel API Documentation

A RESTful API for hotel management, developed with Spring Boot. This API allows creating, listing, updating, and deleting hotels, as well as uploading associated images. It also allows to create users that can book a hotel, edit their accounts and reservations

---

## Automatically inserted objects into the database

- **Hotels:** `23 hotels, 3 with photos, names and descriptions. 20 with a generic name and description`
- **Users:** `1 admin account to acces the admin functions on the frontend`

---

## Overall Architecture

- **Controller:** `HotelController.java` + `UserController.java`
- **Service:** `IHotelService.java` + `HotelServiceImpl.java` + `IUserService.java` + `UserServiceImpl.java`
- **Repository:** `IHotelRepository.java` + `IUserRepository.java`
- **Model:** `Hotel.java` + `User.java`
- **Configuration:** `WebConfig.java`, `ProyectoApiApplication.java`
- **Error Handling:** `ResourceNotFoundException.java`

---

## Data Model

**Hotel.java**

Represents a hotel and its attributes:

```java
Long id;
String hotelName;
Double pricePerNight;
String hotelType;
String hotelAddress;
String hotelCity;
String hotelCountry;
Long hotelPhone;
String hotelEmail;
String hotelWebsite;
String hotelDescription;
Boolean wifi;
Boolean parking;
Boolean pool;
Boolean gym;
Boolean restaurant;
Boolean spa;
Boolean bar;
Boolean laundry;
Boolean roomService;
Boolean conferenceRoom;
List<String> photos;
```

**User.java**

Represents a user and its attributes:

```java
Long id;
String name;
String lastname;
String email;
String password;
String role;
List<Long> reservedHotels;
```

---

## API Endpoints

## Hotel Endpoints

### Create a hotel

- **URL:** `POST /hotel`
- **Body (JSON):**

```json
{
    "hotel_name": "ExampleHotel",
    "hotel_address": "Street 1",
    "price_per_night": 300.0,
    "hotel_type": "hotel",
    "hotel_city": "CityExample",
    "hotel_country": "CountryExample",
    "hotel_phone": 123456789,
    "hotel_email": "examplehotel@gmail.com",
    "hotel_website": "https://examplehotel.com",
    "hotel_description": "Very pretty hotel",
    "has_wifi": false,
    "has_parking": true,
    "has_pool": false,
    "has_gym": true,
    "has_restaurant": false,
    "has_spa": true,
    "has_bar": false,
    "has_laundry": true,
    "has_room_service": false,
    "has_conference_room": true,
    "hotel_photos": ["imageURL1.jpg", "imageURL2.jpg"]
}

```

- **Response:** `201 Created` with the created hotel.

---

### Upload image

- **URL:** `POST /hotel/upload`
- **Request:** `multipart/form-data` with a file.
- **Response:**

```json
{
  "url": "http://localhost:8080/uploads/imageURL.jpg"
}
```

---

### List all hotels

- **URL:** `GET /hotel`
- **Response:** List of all hotels.

---

### Get hotel by ID

- **URL:** `GET /hotel/{id}`
- **Response:** Hotel corresponding to the ID.
- **Error:** `404 Not Found` if it does not exist.

---

### Update hotel

- **URL:** `PUT /hotel/{id}`
- **Body (JSON):**

```json
{
    "hotel_name": "ExampleHotel",
    "hotel_address": "Street 1",
    "price_per_night": 300.0,
    "hotel_type": "hotel",
    "hotel_city": "CityExample",
    "hotel_country": "CountryExample",
    "hotel_phone": 123456789,
    "hotel_email": "examplehotel@gmail.com",
    "hotel_website": "https://examplehotel.com",
    "hotel_description": "Very pretty hotel",
    "has_wifi": false,
    "has_parking": true,
    "has_pool": false,
    "has_gym": true,
    "has_restaurant": false,
    "has_spa": true,
    "has_bar": false,
    "has_laundry": true,
    "has_room_service": false,
    "has_conference_room": true,
    "hotel_photos": ["imageURL1.jpg", "imageURL2.jpg"]
}
```

- **Response:** Updated hotel.
- **Error:** `404 Not Found` if it does not exist.

---

### Delete hotel

- **URL:** `DELETE /hotel/{id}`
- **Response:** `204 No Content`
- **Error:** `404 Not Found` if it does not exist.

---

## Service Logic

### IHotelService.java

Defines the service methods:

```java
List<Hotel> getAllHotels();
Hotel getHotelById(Long id);
Hotel createHotel(Hotel hotel);
Hotel updateHotel(Long id, Hotel hotel);
void deleteHotel(Long id);
```

### HotelServiceImpl.java

Implements the logic using `IHotelRepository` and throws `ResourceNotFoundException` if a hotel is not found.

---

## Repository

### IHotelRepository.java

Extends `JpaRepository<Hotel, Long>` to access the H2 in-memory database automatically.

---

## User Endpoints

### Create a user

- **URL:** `POST /users`
- **Body (JSON):**

```json
{
  "name": "exampleName",
  "last_name": "exampleLastName",
  "email": "example@gmail.com",
  "password": "example"
}
```

- **Response:** `201 Created` with the created user.

---

### List all users

- **URL:** `GET /users`
- **Response:** List of all users.

---

### Get user by ID

- **URL:** `GET /users/{id}`
- **Response:** User corresponding to the ID.
- **Error:** `404 Not Found` if it does not exist.

---

### Update user

- **URL:** `PUT /users/{id}`
- **Body (JSON):**

```json
{
  "name": "exampleName",
  "last_name": "exampleLastName",
  "email": "example@gmail.com",
  "password": "example",
  "role": "user",
  "reserved_hotels": [1,2,3]
}
```

- **Response:** Updated user.
- **Error:** `404 Not Found` if it does not exist.

---

### Delete user

- **URL:** `DELETE /user/{id}`
- **Response:** `204 No Content`
- **Error:** `404 Not Found` if it does not exist.

---

## Service Logic

### IHotelService.java

Defines the service methods:

```java
List<Hotel> getAllHotels();
Hotel getHotelById(Long id);
Hotel createHotel(Hotel hotel);
Hotel updateHotel(Long id, Hotel hotel);
void deleteHotel(Long id);
```

### HotelServiceImpl.java

Implements the logic using `IHotelRepository` and throws `ResourceNotFoundException` if a hotel is not found.

---

### IUserService.java

Defines the service methods:

```java
User save(User u);
Optional<User> findById(Long id);
void update(User u);
void deleteById(Long id) throws ResourceNotFoundException;
List<User> findAll();
List<User> findByNameOrEmail(String ne);
Optional<User> findByEmail(String e);
```

### UserServiceImpl.java

Implements the logic using `IUserRepository` and throws `ResourceNotFoundException` if a user is not found.

---

## Repository

### IHotelRepository.java

Extends `JpaRepository<Hotel, Long>` to access the H2 in-memory database automatically.

---

### IUserRepository.java

Extends `JpaRepository<User, Long>` to access the H2 in-memory database automatically.

---

## Configuration

### WebConfig.java

- Configures CORS.
- Defines the path to serve images from `/uploads`.

---

## Error Handling

### ResourceNotFoundException.java

Custom exception thrown when a hotel by ID is not found.

---
