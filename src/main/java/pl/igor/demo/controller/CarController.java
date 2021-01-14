package pl.igor.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.igor.demo.model.Car;
import pl.igor.demo.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    private CarServiceImpl carServiceImpl;
    private List<Car> carList;


    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
        this.carList = carServiceImpl.getCarList();
    }

}
