package com.example.demo.controllers;

import com.example.demo.Marker;
import com.example.demo.dto.CarDto;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping
    public CarDto create(@RequestBody @Validated({Marker.Create.class}) CarDto carDto) {
        log.info("Received a request to create a car");
        Car car = carService.create(CarMapper.fromCarDto(carDto));
        return CarMapper.toCarDto(car);
    }

    @PatchMapping("/{carId}")
    public CarDto update(@RequestBody @Validated({Marker.Update.class}) CarDto carDto, @PathVariable Long carId) {
        log.info("Received a request to update the car under the ID: {}", carId);
        Car car = carService.update(CarMapper.fromCarDto(carDto), carId);
        return CarMapper.toCarDto(car);
    }

    @GetMapping
    public List<CarDto> getAll() {
        log.info("Received a request to get all car");
        List<Car> cars = carService.getAll();
        return CarMapper.toCarsDtoList(cars);
    }

    @GetMapping("/{carId}")
    public CarDto getById(@PathVariable Long carId) {
        log.info("A request was received to get a car under the ID:{}", carId);
        Car car = carService.getById(carId);
        return CarMapper.toCarDto(car);
    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable Long carId) {
        log.info("A request was received to delete a car under the ID:{}", carId);
        carService.delete(carId);
    }
}
