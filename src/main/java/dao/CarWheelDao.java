package dao;

import java.util.List;
import models.CarWheel;

public interface CarWheelDao {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
