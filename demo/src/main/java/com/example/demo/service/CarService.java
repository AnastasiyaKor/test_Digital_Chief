package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;

public interface CarService {
    Car create(Car car);

    Car update(Car car, long carId);

    Car getById(Long carId);

    List<Car> getAll();

    void delete(Long carId);
}
