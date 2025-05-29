package com.dh.proyectoAPI.service.impl;

import com.dh.proyectoAPI.entity.User;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.repository.IUserRepository;
import com.dh.proyectoAPI.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository repository;

    @Autowired
    public UserServiceImpl(IUserRepository repository) {this.repository = repository;}

    @Override
    public Optional<User> findById(Long id) {return repository.findById(id);};

    @Override
    public User save(User u) {return repository.save(u);};

    @Override
    public void update(User u) {repository.save(u);};

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {repository.deleteById(id);};

    @Override
    public List<User> findAll() {return repository.findAll();};

    @Override
    public List<User> findByNameOrEmail(String ne) {return repository.findByNameOrEmail(ne);};

    @Override
    public Optional<User> findByEmail(String e) {return repository.findByEmail(e);};

}
