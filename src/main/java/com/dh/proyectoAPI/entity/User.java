package com.dh.proyectoAPI.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonAlias("name")
    private String name;

    @Column(name = "last_name", nullable = false)
    @JsonAlias("last_name")
    private String lastname;

    @Column(name = "email", unique = true, nullable = false)
    @JsonAlias("email")
    private String email;

    @Column(name = "password", nullable = false)
    @JsonAlias("password")
    private String password;

    @Column(name = "user_role")
    @JsonAlias("user_role")
    private String role;

    @ManyToMany
    @JoinTable(name = "user_booked_hotels",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    private List<Hotel> bookedHotels;

    @Column(name = "favourite_hotels")
    @JsonAlias("favourite_hotels")
    @ManyToMany
    @JoinTable(name = "user_favourite_hotel",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )
    private List<Hotel> favouriteHotels;

    public Long getId() {
        return id;
    }

    public List<Hotel> getBookedHotels() {
        return bookedHotels;
    }

    public void setBookedHotels(List<Hotel> bookedHotels) {
        this.bookedHotels = bookedHotels;
    }

    public List<Hotel> getFavouriteHotels() {
        return favouriteHotels;
    }

    public void setFavouriteHotels(List<Hotel> favouriteHotels) {
        this.favouriteHotels = favouriteHotels;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", reservedHotels=" + bookedHotels +
                ", favouriteHotels=" + favouriteHotels +
                '}';
    }
}
