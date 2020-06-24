package service.impl;

import dao.CarDoorDao;
import java.util.List;
import lib.Inject;
import lib.Service;
import models.CarDoor;
import service.CarDoorService;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    @Inject
    private CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
