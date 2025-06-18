package com.dh.proyectoAPI.repository;

import com.dh.proyectoAPI.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review, Long> {
}
