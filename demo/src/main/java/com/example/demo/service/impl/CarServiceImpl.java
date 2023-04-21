package com.example.demo.service.impl;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Car;
import com.example.demo.repositoryes.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    @Transactional
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public Car update(Car car, long carId) {
        Car updateCar = getById(carId);

        if (car.getStamp() != null) {
            updateCar.setStamp(car.getStamp());
        }
        if (car.getModel() != null) {
            updateCar.setModel(car.getModel());
        }
        if (car.getYear() != null) {
            updateCar.setYear(car.getYear());
        }
        if (car.getTransmission() != null) {
            updateCar.setTransmission(car.getTransmission());
        }
        if (car.getCarBody() != null) {
            updateCar.setCarBody(car.getCarBody());
        }
        if (car.getCarColorBody() != null) {
            updateCar.setCarColorBody(car.getCarColorBody());
        }
        if (car.getEngineCapacity() != null) {
            updateCar.setEngineCapacity(car.getEngineCapacity());
        }
        if (car.getFuelType() != null) {
            updateCar.setFuelType(car.getFuelType());
        }
        if (car.getDrive() != null) {
            updateCar.setDrive(car.getDrive());
        }
        if (car.getWheel() != null) {
            updateCar.setWheel(car.getWheel());
        }
        if (car.getStateNumber() != null) {
            updateCar.setStateNumber(car.getStateNumber());
        }
        return updateCar;
    }

    @Override
    public Car getById(Long carId) {
        return carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Автомобиль не найден"));
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long carId) {
        carRepository.deleteById(carId);
    }
}
