package pl.igor.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", carList);
        model.addAttribute("request", new Car());
        return "car";
    }

    @PostMapping("/delete")
    public String deleteCar(@RequestParam long id) {
        carServiceImpl.deleteCarById(id);
        return "redirect:/cars";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car newCar) {
        carServiceImpl.getCarList().add(newCar);
        return "redirect:/cars";
    }

    @PostMapping("/clear")
    public String clearCarList() {
        carServiceImpl.clearCarsPage();
        carServiceImpl.initCar();
        return "redirect:/cars";
    }

    @PostMapping("/changePrice")
    public String changePrice(@RequestParam long id, Long price) {
        carServiceImpl.modifyPriceOfCar(price, id);
        return "redirect:/cars";

    }

    @GetMapping("/getForId")
    public String getCarsForId(@RequestParam long id) {
        Car car = carServiceImpl.getCarById(id);
        carServiceImpl.clearCarsPage();
        carServiceImpl.getCarList().add(car);
        return "redirect:/cars";

    }
}
