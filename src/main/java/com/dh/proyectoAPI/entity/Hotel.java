package com.dh.proyectoAPI.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hotel_name", nullable = false, length = 100, unique = true)
    @JsonAlias("hotel_name")
    private String hotelName;

    @Column(name = "price_per_night", nullable = false)
    @JsonAlias("price_per_night")
    private Double pricePerNight;

    @Column(name = "hotel_type", nullable = false)
    @JsonAlias("hotel_type")
    private String hotelType;

    @Column(name = "hotel_address", nullable = false)
    @JsonAlias("hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_city", nullable = false)
    @JsonAlias("hotel_city")
    private String hotelCity;

    @Column(name = "hotel_country", nullable = false)
    @JsonAlias("hotel_country")
    private String hotelCountry;

    @Column(name = "hotel_phone", length = 20, nullable = false)
    @JsonAlias("hotel_phone")
    private Long hotelPhone;

    @Column(name = "hotel_email", nullable = false)
    @JsonAlias("hotel_email")
    private String hotelEmail;

    @Column(name = "hotel_website")
    @JsonAlias("hotel_website")
    private String hotelWebsite;

    @Column(name = "hotel_description", length = 516, nullable = false)
    @JsonAlias("hotel_description")
    private String hotelDescription;

    @Column(name = "has_wifi", nullable = false)
    @JsonAlias("has_wifi")
    private Boolean wifi;

    @Column(name = "has_parking", nullable = false)
    @JsonAlias("has_parking")
    private Boolean parking;

    @Column(name = "has_pool", nullable = false)
    @JsonAlias("has_pool")
    private Boolean pool;

    @Column(name = "has_gym", nullable = false)
    @JsonAlias("has_gym")
    private Boolean gym;

    @Column(name = "has_restaurant", nullable = false)
    @JsonAlias("has_restaurant")
    private Boolean restaurant;

    @Column(name = "has_spa", nullable = false)
    @JsonAlias("has_spa")
    private Boolean spa;

    @Column(name = "has_bar", nullable = false)
    @JsonAlias("has_bar")
    private Boolean bar;

    @Column(name = "has_laundry", nullable = false)
    @JsonAlias("has_laundry")
    private Boolean laundry;

    @Column(name = "has_room_service", nullable = false)
    @JsonAlias("has_room_service")
    private Boolean roomService;

    @Column(name = "has_conference_room", nullable = false)
    @JsonAlias("has_conference_room")
    private Boolean conferenceRoom;

    @Column(name = "hotel_photos", nullable = false)
    @JsonAlias("hotel_photos")
    private List<String> photos;

    public Long getId() {
        return id;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                ", hotelCountry='" + hotelCountry + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                ", hotelWebsite='" + hotelWebsite + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                ", wifi=" + wifi +
                ", parking=" + parking +
                ", pool=" + pool +
                ", gym=" + gym +
                ", restaurant=" + restaurant +
                ", spa=" + spa +
                ", bar=" + bar +
                ", laundry=" + laundry +
                ", roomService=" + roomService +
                ", conferenceRoom=" + conferenceRoom +
                ", photos='" + photos + '\'' +
                '}';
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public Long getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(Long hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getHotelWebsite() {
        return hotelWebsite;
    }

    public void setHotelWebsite(String hotelWebsite) {
        this.hotelWebsite = hotelWebsite;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    public Boolean getGym() {
        return gym;
    }

    public void setGym(Boolean gym) {
        this.gym = gym;
    }

    public Boolean getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Boolean restaurant) {
        this.restaurant = restaurant;
    }

    public Boolean getSpa() {
        return spa;
    }

    public void setSpa(Boolean spa) {
        this.spa = spa;
    }

    public Boolean getBar() {
        return bar;
    }

    public void setBar(Boolean bar) {
        this.bar = bar;
    }

    public Boolean getLaundry() {
        return laundry;
    }

    public void setLaundry(Boolean laundry) {
        this.laundry = laundry;
    }

    public Boolean getRoomService() {
        return roomService;
    }

    public void setRoomService(Boolean roomService) {
        this.roomService = roomService;
    }

    public Boolean getConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(Boolean conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
