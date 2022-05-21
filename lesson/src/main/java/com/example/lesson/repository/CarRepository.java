package com.example.lesson.repository;

import com.example.lesson.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Cars, Long> {
    List<Cars> findAllByYear(int year);
}
