package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stamp")
    private String stamp;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "car_body")
    private String carBody;
    @Column(name = "car_color_body")
    private String carColorBody;
    @Column(name = "engine_capacity")
    private String engineCapacity;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "drive")
    private String drive;
    @Column(name = "wheel")
    private String wheel;
    @Column(name = "state_number")
    private String stateNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    @ToString.Exclude
    private User owner;
    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @PrePersist
    private void init() {
        dateAdded = LocalDateTime.now();
    }
}
