package hibernatehw.service.impl;

import hibernatehw.dao.CarWheelDao;
import hibernatehw.lib.Inject;
import hibernatehw.lib.Service;
import hibernatehw.models.CarWheel;
import hibernatehw.service.CarWheelService;
import java.util.List;

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
