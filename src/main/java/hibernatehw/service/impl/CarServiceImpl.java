package hibernatehw.service.impl;

import hibernatehw.dao.CarDao;
import hibernatehw.lib.Inject;
import hibernatehw.lib.Service;
import hibernatehw.models.Car;
import hibernatehw.service.CarService;
import java.util.List;

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
