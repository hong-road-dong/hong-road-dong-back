package com.opensource.hongroaddong.domain.car.repository;

import com.opensource.hongroaddong.domain.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByCarNumber(String carNumber);
}
