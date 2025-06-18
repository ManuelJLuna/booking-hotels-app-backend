package com.dh.proyectoAPI.controller;

import com.dh.proyectoAPI.entity.Hotel;
import com.dh.proyectoAPI.entity.Reservation;
import com.dh.proyectoAPI.entity.User;
import com.dh.proyectoAPI.exception.ResourceNotFoundException;
import com.dh.proyectoAPI.service.IHotelService;
import com.dh.proyectoAPI.service.IReservationService;
import com.dh.proyectoAPI.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private IReservationService service;
    private IUserService userService;
    private IHotelService hotelService;

    @Autowired
    public ReservationController(IReservationService service, IUserService userService, IHotelService hotelService) {
        this.service = service;
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id){
        Optional<Reservation> reservation = service.findById(id);

        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
        Optional<Hotel> hotel = hotelService.findById(reservation.getHotel().getId());
        Optional<User> user = userService.findById(reservation.getUser().getId());

        if (hotel.isPresent()){
            reservation.setHotel(hotel.get());
        }
        if (user.isPresent()){
            reservation.setUser(user.get());
        }

        return ResponseEntity.ok(service.save(reservation));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Reservation reservation) {
        ResponseEntity<String> response;
        Optional<Reservation> reservationToLookFor = service.findById(reservation.getId());

        if (reservationToLookFor.isPresent()) {
            service.update(reservation);
            response = ResponseEntity.ok("Se actualizó la reserva: " + reservation.getId());

        } else {
            response = ResponseEntity.ok().body("No se puede actualizar una reserva que no existe en la base de datos");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.ok("Se eliminó la reserva con id: " + id);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<?> findByCity(@RequestParam Long hotelId, @RequestParam LocalDate checkIn, @RequestParam LocalDate checkOut) throws Exception {
        List<Reservation> reservation = service.findReservationsByHotelAndDates(hotelId, checkIn, checkOut);
        if (reservation.isEmpty()) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El hotel ya esta reservado en esas fechas");
        }
    }

}
