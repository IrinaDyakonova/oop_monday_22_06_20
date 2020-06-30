package hibernatehw.service;

import hibernatehw.models.CarDoor;
import java.util.List;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();

    CarDoor findById(Long id);

}
