package dao;

import java.util.List;
import models.CarDoor;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
