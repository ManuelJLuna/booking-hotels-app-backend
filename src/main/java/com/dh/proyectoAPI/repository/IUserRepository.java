package com.dh.proyectoAPI.repository;

import com.dh.proyectoAPI.entity.Hotel;
import com.dh.proyectoAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<User> findByNameOrEmail(String ne);

    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(?1)")
    Optional<User> findByEmail(String e);

}
