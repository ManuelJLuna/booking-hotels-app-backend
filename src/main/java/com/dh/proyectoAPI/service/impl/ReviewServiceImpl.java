package com.dh.proyectoAPI.service.impl;

import com.dh.proyectoAPI.entity.Review;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.repository.IReviewRepository;
import com.dh.proyectoAPI.repository.IUserRepository;
import com.dh.proyectoAPI.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements IReviewService {

    private IReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(IReviewRepository repository) {this.repository = repository;}

    @Override
    public Review save(Review r) {return repository.save(r);}

    @Override
    public Optional<Review> findById(Long id) {return repository.findById(id);}

    @Override
    public void update(Review r) {repository.save(r);}

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {repository.deleteById(id);}

    @Override
    public List<Review> findAll() {return repository.findAll();}
}
