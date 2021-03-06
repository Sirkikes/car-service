package com.ms.tutorial.carservice.controller;

import com.ms.tutorial.carservice.entity.Car;
import com.ms.tutorial.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = carService.getAll();
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id){
        Car car = carService.getCarById(id);
        if(car == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    @PostMapping()
    public ResponseEntity<Car> save(@RequestBody Car car){
        Car carNew = carService.saveCar(car);
        return ResponseEntity.ok(carNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId){
        List<Car> cars = carService.byUserId(userId);
        return ResponseEntity.ok(cars);
    }



}
