package com.dh.proyectoAPI.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonAlias("user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonAlias("hotel_id")
    private Hotel hotel;

    @Column(name = "check_in", nullable = false)
    @JsonAlias("check_in")
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    @JsonAlias("check_out")
    private LocalDate checkOut;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", hotel=" + hotel +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
