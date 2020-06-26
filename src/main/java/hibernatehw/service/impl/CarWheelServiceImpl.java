package hibernatehw.service.impl;

import hibernatehw.dao.CarWheelDao;
import hibernatehw.models.CarWheel;
import hibernatehw.service.CarWheelService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    private CarWheelDao carWheelDao;

    public CarWheelServiceImpl(CarWheelDao carWheelDao) {
        this.carWheelDao = carWheelDao;
    }

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
