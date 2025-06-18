package com.dh.proyectoAPI.service.impl;

import com.dh.proyectoAPI.entity.Reservation;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.repository.IReservationRepository;
import com.dh.proyectoAPI.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements IReservationService {

    private IReservationRepository repository;

    @Autowired
    public ReservationServiceImpl(IReservationRepository repository){this.repository = repository;}


    @Override
    public Reservation save(Reservation r) {return repository.save(r);}

    @Override
    public Optional<Reservation> findById(Long id) {return repository.findById(id);}

    @Override
    public void update(Reservation r) {repository.save(r);}

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {repository.deleteById(id);}

    @Override
    public List<Reservation> findAll() {return repository.findAll();}

    @Override
    public List<Reservation> findReservationsByHotelAndDates(Long hotelId, LocalDate checkIn, LocalDate checkOut) {return repository.findReservationsByHotelAndDates(hotelId, checkIn, checkOut);}
}
