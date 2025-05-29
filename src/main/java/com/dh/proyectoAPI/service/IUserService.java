package com.dh.proyectoAPI.service;


import com.dh.proyectoAPI.entity.User;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User save(User u);

    Optional<User> findById(Long id);

    void update(User u);

    void deleteById(Long id) throws ResourceNotFoundException;

    List<User> findAll();

    List<User> findByNameOrEmail(String ne);

    Optional<User> findByEmail(String e);
}
