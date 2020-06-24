package service.impl;

import dao.CarDao;
import java.util.List;
import lib.Inject;
import lib.Service;
import models.Car;
import service.CarService;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
}
