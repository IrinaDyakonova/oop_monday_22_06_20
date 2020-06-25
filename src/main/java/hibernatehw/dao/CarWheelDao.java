package hibernatehw.dao;

import hibernatehw.models.CarWheel;
import java.util.List;

public interface CarWheelDao {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
