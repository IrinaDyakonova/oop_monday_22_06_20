package hibernatehw.dao;

import hibernatehw.models.CarDoor;
import java.util.List;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
