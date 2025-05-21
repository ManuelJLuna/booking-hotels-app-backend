package com.dh.proyectoAPI.service.impl;


import com.dh.proyectoAPI.entity.Hotel;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.repository.IHotelRepository;
import com.dh.proyectoAPI.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {

    private IHotelRepository repository;

    @Autowired
    public HotelServiceImpl(IHotelRepository repository){this.repository = repository;}

    @Override
    public Hotel save(Hotel h){return repository.save(h);}

    @Override
    public Optional<Hotel> findById(Long id) {return repository.findById(id);}

    @Override
    public void update(Hotel h) {repository.save(h);}

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {repository.deleteById(id);}

    @Override
    public List<Hotel> findAll() {return repository.findAll();}

    @Override
    public List<Hotel> findByCityCountry(String c) {return repository.findByCityCountry(c);}

    @Override
    public List<Hotel> findByType(String t) {return repository.findByType(t);}

}
