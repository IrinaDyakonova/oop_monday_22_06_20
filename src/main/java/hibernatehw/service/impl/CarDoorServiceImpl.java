package hibernatehw.service.impl;

import hibernatehw.dao.CarDoorDao;
import hibernatehw.models.CarDoor;
import hibernatehw.service.CarDoorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    private CarDoorDao carDoorDao;

    public CarDoorServiceImpl(CarDoorDao carDoorDao) {
        this.carDoorDao = carDoorDao;
    }

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
