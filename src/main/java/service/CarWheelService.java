package service;

import java.util.List;
import models.CarWheel;

public interface CarWheelService {

    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
