package web.controllers;

import model.Car;
import org.springframework.web.bind.annotation.PathVariable;
import web.dao.CarDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarStoreControler {

    private final CarDAOImpl carDAO;

    @Autowired
    public CarStoreControler(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = "")
    public String printСars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> answer;
        if (count != null) {
            answer = carDAO.viewCarList(count);
        } else {
            answer = carDAO.viewAllCars();
        }
        model.addAttribute(answer);
        return "carstore";
    }

}
