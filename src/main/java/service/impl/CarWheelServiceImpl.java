package service.impl;

import dao.CarWheelDao;
import java.util.List;
import lib.Inject;
import lib.Service;
import models.CarWheel;
import service.CarWheelService;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    @Inject
    private CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
