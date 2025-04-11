package web.controllers;

import model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarStoreControler {

    private final CarService carService;

    @Autowired
    public CarStoreControler(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "")
    public String printСars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> answer = carService.viewCarList(count);

        model.addAttribute(answer);
        return "carstore";
    }

}
