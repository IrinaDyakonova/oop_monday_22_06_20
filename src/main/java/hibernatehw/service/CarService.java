package hibernatehw.service;

import hibernatehw.models.Car;
import java.util.List;

public interface CarService {
    Car add(Car car);

    List<Car> getAll();
}
