package service;

import java.util.List;
import models.CarDoor;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
