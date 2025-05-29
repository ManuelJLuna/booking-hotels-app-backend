package com.dh.proyectoAPI.controller;

import com.dh.proyectoAPI.entity.User;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService service;

    @Autowired
    public UserController (IUserService service) {this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> user = service.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody User user) {
        ResponseEntity<String> response;
        Optional<User> userToLookFor = service.findById(user.getId());

        if (userToLookFor.isPresent()) {
            service.update(user);
            response = ResponseEntity.ok("Se actualizó el usuario: " + user.getName());

        } else {
            response = ResponseEntity.ok().body("No se puede actualizar un usuario que no existe en la base de datos");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.ok("Se eliminó el usuario con id: " + id);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/nameOrEmail/{nameOrEmail}")
    public ResponseEntity<List<User>> findByNameOrEmail(@PathVariable String nameOrEmail){
        List<User> user = service.findByNameOrEmail(nameOrEmail);

        if (!user.isEmpty()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        Optional<User> user = service.findByEmail(email);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
