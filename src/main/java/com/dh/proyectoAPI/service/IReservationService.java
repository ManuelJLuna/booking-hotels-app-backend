package com.dh.proyectoAPI.service;

import com.dh.proyectoAPI.entity.Reservation;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReservationService {

    Reservation save(Reservation r);

    Optional<Reservation> findById(Long id);

    void update(Reservation r);

    void deleteById(Long id) throws ResourceNotFoundException;

    List<Reservation> findAll();

    List<Reservation> findReservationsByHotelAndDates(Long hotelId, LocalDate checkIn, LocalDate checkOut);


}
