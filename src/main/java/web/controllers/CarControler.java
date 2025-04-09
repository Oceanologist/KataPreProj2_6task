package web.controllers;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarControler {
    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count") int count, ModelMap model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry V6", 301));
        carList.add(new Car("BMW", "M5 Competition", 625));
        carList.add(new Car("Ford", "Mustang GT", 450));
        carList.add(new Car("Mercedes", "E 63 AMG", 613));
        carList.add(new Car("UAZ", "Patriot", 107));
        StringBuilder answer=new StringBuilder();
        for (int i = 0; i < count; i++) {
            answer.append(carList.get(i).toString()).append("\n").append("<br>");

        }
        model.addAttribute("car", answer.toString());

        return "carstore";
    }
}
