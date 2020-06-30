package hibernatehw.controllers;

import hibernatehw.interfaces.PrintInterface;
import hibernatehw.models.Car;
import hibernatehw.models.CarDoor;
import hibernatehw.models.CarWheel;
import hibernatehw.service.CarDoorService;
import hibernatehw.service.CarService;
import hibernatehw.service.CarWheelService;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectController {

    private final CarService carService;
    private final CarWheelService carWheelService;
    private final CarDoorService carDoorService;

    public InjectController(
            CarService carService,
            CarWheelService carWheelService,
            CarDoorService carDoorService) {
        this.carService = carService;
        this.carWheelService = carWheelService;
        this.carDoorService = carDoorService;
    }

    @PostConstruct
    public String inject() {
        CarDoor carDoor1 = new CarDoor();
        carDoor1.openDoor();
        carDoorService.add(carDoor1);
        CarDoor carDoor2 = new CarDoor();
        carDoorService.add(carDoor2);
        CarDoor carDoor3 = new CarDoor();
        carDoor3.openDoor();
        carDoorService.add(carDoor3);
        CarDoor carDoor4 = new CarDoor();
        carDoorService.add(carDoor4);

        List<CarDoor> carDoorList;
        carDoorList = carDoorService.getAll();

        CarWheel carWheel1 = new CarWheel();
        carWheelService.add(carWheel1);
        CarWheel carWheel2 = new CarWheel();
        carWheelService.add(carWheel2);
        CarWheel carWheel3 = new CarWheel();
        carWheelService.add(carWheel3);
        CarWheel carWheel4 = new CarWheel();
        carWheelService.add(carWheel4);
        CarWheel carWheel5 = new CarWheel();
        carWheelService.add(carWheel5);
        CarWheel carWheel6 = new CarWheel();
        carWheelService.add(carWheel6);

        List<CarWheel> carWheels;
        carWheels = carWheelService.getAll();
        carWheels.stream().peek(PrintInterface::printObjectData);

        Car car = new Car();
        car.setAccelerationTime(10);
        car.setCarDoors(carDoorList);
        LocalDateTime localDate = LocalDateTime.now();
        car.setDateOfManufacture(localDate);
        car.setAccelerationTime(10);
        car.setMaxSpeed(250);
        car.setNumberOfPassengersAtTheMoment(5);
        car.setPassengerCapacity(8);
        car.setCarWheels(carWheels);
        carService.add(car);

        return "Inject add to DB!";
    }
}
