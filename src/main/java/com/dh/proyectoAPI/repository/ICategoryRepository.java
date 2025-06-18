package com.dh.proyectoAPI.repository;

import com.dh.proyectoAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
