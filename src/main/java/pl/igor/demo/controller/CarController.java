package pl.igor.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String deleteCa(@RequestParam long id) {
        carServiceImpl.deleteCarById(id);
        return "redirect:/car";

    }


}
