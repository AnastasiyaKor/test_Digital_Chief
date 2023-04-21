package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", orphanRemoval = true)
    @ToString.Exclude
    private List<Car> cars;
    @Column(name = "created")
    private LocalDateTime created;

    public void addCar(Car car) {
        this.cars.add(car);
        car.setOwner(this);
    }

    public void remove(Car car) {
        this.cars.remove(car);
        car.setOwner(null);
    }

    @PrePersist
    private void init() {
        created = LocalDateTime.now();
    }
}
