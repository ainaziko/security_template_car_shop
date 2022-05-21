package com.example.lesson.service;

import com.example.lesson.dto.CarDto;
import com.example.lesson.entity.Cars;
import com.example.lesson.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> getAllCarsByYear(int year){
        List<CarDto> cars = new ArrayList<>();
        List<Cars> carsEnt = carRepository.findAllByYear(year);

        for (Cars car: carsEnt) {
            CarDto curr = new CarDto();
            curr.setId(car.getId());
            curr.setName(car.getName());
            cars.add(curr);
        }
        return cars;
    }

}
