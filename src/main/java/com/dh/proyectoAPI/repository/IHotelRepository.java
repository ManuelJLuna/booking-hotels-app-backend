package com.dh.proyectoAPI.repository;

import com.dh.proyectoAPI.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Long> {


    @Query("SELECT h FROM Hotel h WHERE LOWER(h.hotelCity) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(h.hotelCountry) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Hotel> findByCityCountry(String c);

    @Query("SELECT h FROM Hotel h WHERE LOWER(h.hotelName) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Hotel> findByHotelName(String n);

    @Query("SELECT h FROM Hotel h WHERE h.hotelType=?1")
    List<Hotel> findByType(String c);

}
