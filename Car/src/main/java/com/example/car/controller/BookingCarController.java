package com.example.car.controller;

import com.example.car.model.BookingCar;
import com.example.car.service.BookingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingCarController {
    private final BookingCarService bookingCarService;

    @Autowired
    public BookingCarController(BookingCarService bookingCarService) {
        this.bookingCarService = bookingCarService;
    }

    @GetMapping
    public ResponseEntity<List<BookingCar>> getAllBookings() {
        List<BookingCar> bookings = bookingCarService.getAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingCar> getBookingById(@PathVariable Long id) {
        BookingCar booking = bookingCarService.getById(id).get();
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookingCar> createBooking(@RequestBody BookingCar bookingCar) {
        BookingCar createdBooking = bookingCarService.create(bookingCar);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingCar> updateBooking(@PathVariable Long id, @RequestBody BookingCar bookingCar) {
        BookingCar updatedBooking = bookingCarService.update(id, bookingCar);
        if (updatedBooking != null) {
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        boolean deleted = bookingCarService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
