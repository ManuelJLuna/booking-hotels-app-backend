package com.dh.proyectoAPI.service;

import com.dh.proyectoAPI.entity.Category;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category save(Category c);

    Optional<Category> findById(Long id);

    void update(Category c);

    void deleteById(Long id) throws ResourceNotFoundException;

    List<Category> findAll();

}
