package com.example.car.service;

import com.example.car.model.BookingCar;
import com.example.car.repository.BookingCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingCarService implements BaseService<BookingCar, Long> {
    private final BookingCarRepository bookingCarRepository;

    @Autowired
    public BookingCarService(BookingCarRepository bookingCarRepository) {
        this.bookingCarRepository = bookingCarRepository;
    }

    @Override
    public List<BookingCar> getAll() {
        return bookingCarRepository.findAll();
    }

    @Override
    public Optional<BookingCar> getById(Long id) {
        return bookingCarRepository.findById(id);
    }

    @Override
    public BookingCar create(BookingCar bookingCar) {
        return bookingCarRepository.save(bookingCar);
    }

    @Override
    public BookingCar update(Long id, BookingCar bookingCar) {
        Optional<BookingCar> optionalBookingCar = bookingCarRepository.findById(id);
        if (optionalBookingCar.isPresent()) {
            BookingCar existingBookingCar = optionalBookingCar.get();
            // Perform updates on existingBookingCar using bookingCar properties
            return bookingCarRepository.save(existingBookingCar);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<BookingCar> optionalBookingCar = bookingCarRepository.findById(id);
        if (optionalBookingCar.isPresent()) {
            bookingCarRepository.delete(optionalBookingCar.get());
            return true;
        }
        return false;
    }
}
