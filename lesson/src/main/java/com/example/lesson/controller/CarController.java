package com.example.lesson.controller;

import com.example.lesson.dto.CarDto;
import com.example.lesson.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/get-by-year/{year}")
    public List<CarDto> getAllByYear(@PathVariable int year){
        return carService.getAllCarsByYear(year);
    }
}
