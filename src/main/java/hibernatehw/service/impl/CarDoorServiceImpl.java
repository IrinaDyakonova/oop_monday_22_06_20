package hibernatehw.service.impl;

import hibernatehw.dao.CarDoorDao;
import hibernatehw.lib.Inject;
import hibernatehw.lib.Service;
import hibernatehw.models.CarDoor;
import hibernatehw.service.CarDoorService;
import java.util.List;

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
