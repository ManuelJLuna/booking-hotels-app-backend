package com.dh.proyectoAPI.repository;

import com.dh.proyectoAPI.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.hotel.id = :hotelId AND r.checkIn < :checkOut AND r.checkOut > :checkIn")
    List<Reservation> findReservationsByHotelAndDates(
            @Param("hotelId") Long hotelId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut
    );

    @Query("SELECT r.hotel.id FROM Reservation r WHERE (:checkOut > r.checkIn AND :checkIn < r.checkOut)")
    List<Long> findHotelIdsWithOverlappingReservations(LocalDate checkIn, LocalDate checkOut);

}
