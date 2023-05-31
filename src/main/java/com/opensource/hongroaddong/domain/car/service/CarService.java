package com.opensource.hongroaddong.domain.car.service;

import com.opensource.hongroaddong.domain.car.entity.Car;
import com.opensource.hongroaddong.domain.car.repository.CarRepository;
import com.opensource.hongroaddong.global.error.exception.common.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.opensource.hongroaddong.global.error.dto.ErrorCode.CAR_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public Car findCar(String carNumber) {
        return carRepository.findCarByCarNumber(carNumber)
                .orElseThrow(() -> new NotFoundException(CAR_NOT_FOUND));
    }

}
