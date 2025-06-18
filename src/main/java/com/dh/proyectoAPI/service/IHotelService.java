package com.dh.proyectoAPI.service;


import com.dh.proyectoAPI.entity.Hotel;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHotelService {

    Hotel save(Hotel h);

    Optional<Hotel> findById(Long id);

    void update(Hotel h);

    void deleteById(Long id) throws ResourceNotFoundException;

    List<Hotel> findAll();

    List<Hotel> findByType(String t);

    List<Hotel> findByHotelName(String n);

    List<Hotel> findByCityCountryAndAvailability(String cityCountry, LocalDate checkIn, LocalDate checkOut);

}
