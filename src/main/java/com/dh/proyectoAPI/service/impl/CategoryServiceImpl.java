package com.dh.proyectoAPI.service.impl;

import com.dh.proyectoAPI.entity.Category;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.repository.ICategoryRepository;
import com.dh.proyectoAPI.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private ICategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(ICategoryRepository repository){this.repository = repository;}

    @Override
    public Category save(Category c) {return repository.save(c);}

    @Override
    public Optional<Category> findById(Long id) {return repository.findById(id);}

    @Override
    public void update(Category c) {repository.save(c);}

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {repository.deleteById(id);}

    @Override
    public List<Category> findAll() {return repository.findAll();}
}
