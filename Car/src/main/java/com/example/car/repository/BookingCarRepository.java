package com.example.car.repository;

import com.example.car.model.BookingCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingCarRepository extends JpaRepository<BookingCar, Long> {
}
