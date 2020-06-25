package hibernatehw.dao;

import hibernatehw.models.Car;
import java.util.List;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();
}
