package com.example.demo.mapper;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CarMapper {

    public static CarDto toCarDto(Car car){
        return CarDto.builder()
                .id(car.getId())
                .stamp(car.getStamp())
                .model(car.getModel())
                .year(car.getYear())
                .transmission(car.getTransmission())
                .carBody(car.getCarBody())
                .carColorBody(car.getCarColorBody())
                .engineCapacity(car.getEngineCapacity())
                .fuelType(car.getFuelType())
                .drive(car.getDrive())
                .wheel(car.getWheel())
                .stateNumber(car.getStateNumber())
                .owner(car.getOwner().getId())
                .build();
    }

    public static Car fromCarDto(CarDto carDto){
        return Car.builder()
                .id(carDto.getId())
                .stamp(carDto.getStamp())
                .model(carDto.getModel())
                .year(carDto.getYear())
                .transmission(carDto.getTransmission())
                .carBody(carDto.getCarBody())
                .carColorBody(carDto.getCarColorBody())
                .engineCapacity(carDto.getEngineCapacity())
                .fuelType(carDto.getFuelType())
                .drive(carDto.getDrive())
                .wheel(carDto.getWheel())
                .stateNumber(carDto.getStateNumber())
                .owner(User.builder()
                        .id(carDto.getOwner())
                        .build())
                .build();
    }

    public static List<CarDto> toCarsDtoList(List<Car> cars){
        return cars.stream()
                .map(CarMapper::toCarDto)
                .collect(Collectors.toList());
    }
}
