package web.service;

import model.Car;

import java.util.List;

public interface CarService {

    public List<Car> viewCarList(Integer count);
}
