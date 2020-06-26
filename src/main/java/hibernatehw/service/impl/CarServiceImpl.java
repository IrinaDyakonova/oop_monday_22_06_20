package hibernatehw.service.impl;

import hibernatehw.dao.CarDao;
import hibernatehw.models.Car;
import hibernatehw.service.CarService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
}
