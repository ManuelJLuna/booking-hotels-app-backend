package com.dh.proyectoAPI.controller;

import com.dh.proyectoAPI.entity.Category;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private ICategoryService service;

    @Autowired
    public CategoryController(ICategoryService service){this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Optional<Category> category = service.findById(id);

        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.ok(service.save(category));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Category category) {
        ResponseEntity<String> response;
        Optional<Category> categoryToLookFor = service.findById(category.getId());

        if (categoryToLookFor.isPresent()) {
            service.update(category);
            response = ResponseEntity.ok("Se actualizó la categoria: " + category.getId());

        } else {
            response = ResponseEntity.ok().body("No se puede actualizar una categoria que no existe en la base de datos");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.ok("Se eliminó la categoria con id: " + id);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
