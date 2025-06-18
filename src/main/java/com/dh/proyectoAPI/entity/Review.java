package com.dh.proyectoAPI.entity;

import com.dh.proyectoAPI.entity.Hotel;
import com.dh.proyectoAPI.entity.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rating", nullable = false)
    @JsonAlias("rating")
    private int rating;

    @Column(name = "comment")
    @JsonAlias("comment")
    private String comment;

    @Column(name = "created_at")
    @JsonAlias("created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonAlias("hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonAlias("user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                ", hotel=" + hotel +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}