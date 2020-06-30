package hibernatehw.service;

import hibernatehw.models.CarWheel;
import java.util.List;

public interface CarWheelService {

    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();

    CarWheel findById(Long id);

}
