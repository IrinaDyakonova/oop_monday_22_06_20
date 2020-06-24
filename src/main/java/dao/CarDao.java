package dao;

import java.util.List;
import models.Car;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();
}
