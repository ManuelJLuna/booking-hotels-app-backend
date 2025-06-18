package com.dh.proyectoAPI.service;

import com.dh.proyectoAPI.entity.Review;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IReviewService {

    Review save(Review r);

    Optional<Review> findById(Long id);

    void update(Review r);

    void deleteById(Long id) throws ResourceNotFoundException;

    List<Review> findAll();

}
