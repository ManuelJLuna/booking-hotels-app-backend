package com.dh.proyectoAPI.controller;

import com.dh.proyectoAPI.entity.Review;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/review")
public class ReviewController {

    private IReviewService service;

    @Autowired
    public ReviewController(IReviewService service) {this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id){
        Optional<Review> review = service.findById(id);

        if (review.isPresent()) {
            return ResponseEntity.ok(review.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Review> save(@RequestBody Review review) {
        return ResponseEntity.ok(service.save(review));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Review review) {
        ResponseEntity<String> response;
        Optional<Review> reviewToLookFor = service.findById(review.getId());

        if (reviewToLookFor.isPresent()) {
            service.update(review);
            response = ResponseEntity.ok("Se actualizó la reseña: " + review.getId());

        } else {
            response = ResponseEntity.ok().body("No se puede actualizar una reseña que no existe en la base de datos");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.ok("Se eliminó la reseña con id: " + id);
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
