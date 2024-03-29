package com.example.car.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private int year;
    private String description;
    @Lob
    @Column(name = "image")
    private byte[] image;
    private int pricePerDay;
    private double rentalPrice;
    private boolean isRented;
    private boolean isDelete;

}
