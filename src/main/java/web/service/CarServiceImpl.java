package web.service;

import model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Toyota", "Camry V6", 301));
        cars.add(new Car("BMW", "M5 Competition", 625));
        cars.add(new Car("Ford", "Mustang GT", 450));
        cars.add(new Car("Mercedes", "E 63 AMG", 613));
        cars.add(new Car("UAZ", "Patriot", 107));
    }

    public List<Car> viewCarList(Integer count) {
        if (count == null) {
            return cars;
        }
        if (count > cars.size()) {
            return cars;
        }
        List<Car> answer = new ArrayList<>();
        for (int i = 0; i < count; i++)
            answer.add(cars.get(i));
        return answer;
    }

}
