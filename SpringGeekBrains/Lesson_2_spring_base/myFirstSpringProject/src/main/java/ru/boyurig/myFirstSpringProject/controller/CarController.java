package ru.boyurig.myFirstSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.boyurig.myFirstSpringProject.model.Car;

@RestController
public class CarController {

    @Autowired
    Car car;

    @GetMapping("/car")
    public String startCar(){

        return car.start();
    }
}
