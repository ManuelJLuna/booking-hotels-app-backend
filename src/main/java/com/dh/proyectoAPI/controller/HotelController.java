package com.dh.proyectoAPI.controller;

import com.dh.proyectoAPI.entity.Hotel;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/hotel")
public class HotelController {

    private IHotelService service;

    @Autowired
    public HotelController(IHotelService service){this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Long id){
        Optional<Hotel> hotel = service.findById(id);

        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(service.save(hotel));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Hotel hotel) {
        ResponseEntity<String> response;
        Optional<Hotel> dentistToLookFor = service.findById(hotel.getId());

        if (dentistToLookFor.isPresent()) {
            service.update(hotel);
            response = ResponseEntity.ok("Se actualizó el hotel: " + hotel.getHotelName());

        } else {
            response = ResponseEntity.ok().body("No se puede actualizar un hotel que no existe en la base de datos");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.ok("Se eliminó el hotel con id: " + id);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/citycountry/{citycountry}")
    public ResponseEntity<?> findByCity(@PathVariable String citycountry) throws Exception {
        List<Hotel> hotel = service.findByCityCountry(citycountry);
        if (!hotel.isEmpty()) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron hoteles en: " + citycountry);
        }
    }

    @GetMapping("/category/{type}")
    public ResponseEntity<?> findByType(@PathVariable String type) throws Exception {
        List<Hotel> hotel = service.findByType(type);
        if (!hotel.isEmpty()) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron: " + type);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadImages(@RequestParam("files") MultipartFile[] files) {
        List<String> imageUrls = new ArrayList<>();
        String folder = "uploads/";

        try {
            for (MultipartFile file : files) {
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                Path path = Paths.get(folder + filename);
                Files.write(path, file.getBytes());

                String imageUrl = "/uploads/" + filename;
                imageUrls.add(imageUrl);
            }

            return ResponseEntity.ok(imageUrls);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonList("Error al subir las imágenes"));
        }
    }

}
