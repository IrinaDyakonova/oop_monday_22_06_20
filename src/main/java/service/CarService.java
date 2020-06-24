package service;

import java.util.List;
import models.Car;

public interface CarService {
    Car add(Car car);

    List<Car> getAll();
}
