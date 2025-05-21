# Hotel API Documentation

A RESTful API for hotel management, developed with Spring Boot. This API allows creating, listing, updating, and deleting hotels, as well as uploading associated images.

---

## Overall Architecture

- **Controller:** `HotelController.java`
- **Service:** `IHotelService.java` + `HotelServiceImpl.java`
- **Repository:** `IHotelRepository.java`
- **Model:** `Hotel.java`
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

---

## API Endpoints

### Create a hotel

- **URL:** `POST /hotel`
- **Body (JSON):**

```json
{
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

## Configuration

### WebConfig.java

- Configures CORS.
- Defines the path to serve images from `/uploads`.

---

## Error Handling

### ResourceNotFoundException.java

Custom exception thrown when a hotel by ID is not found.

---
