package hibernatehw.mapper;

import hibernatehw.dto.CarRequestDto;
import hibernatehw.dto.CarResponseDto;
import hibernatehw.models.Car;
import hibernatehw.models.CarDoor;
import hibernatehw.models.CarWheel;
import hibernatehw.service.CarDoorService;
import hibernatehw.service.CarWheelService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    private final CarDoorService carDoorService;
    private final CarWheelService carWheelService;

    public CarMapper(CarDoorService carDoorService, CarWheelService carWheelService) {
        this.carDoorService = carDoorService;
        this.carWheelService = carWheelService;
    }

    public CarResponseDto toDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setAccelerationTime(car.getAccelerationTime());
        carResponseDto.setDateOfManufacture(car.getDateOfManufacture());
        carResponseDto
                .setDoorId(car
                        .getCarDoors()
                        .stream()
                        .map(carDoor -> carDoor.getId())
                        .collect(Collectors.toList()));
        carResponseDto.setEngineType(car.getEngineType());
        carResponseDto.setId(car.getId());
        carResponseDto.setMaxSpeed(car.getMaxSpeed());
        carResponseDto.setPassengerCapacity(car.getPassengerCapacity());
        carResponseDto.setSpeedAtTheMoment(car.getSpeedAtTheMoment());
        carResponseDto
                .setWheelId(car
                        .getCarWheels()
                        .stream()
                        .map(carWheel -> carWheel.getId())
                        .collect(Collectors.toList()));
        return carResponseDto;
    }

    public Car toEntity(CarRequestDto carRequestDto) {
        Car car = new Car();
        car.setDateOfManufacture(carRequestDto.getDateOfManufacture());
        List<CarDoor> carDoorList = carRequestDto
                .getDoorId()
                .stream()
                .map(s -> carDoorService.findById(s))
                .collect(Collectors.toList());
        car.setCarDoors(carDoorList);
        List<CarWheel> carWheelList = carRequestDto
                .getWheelId()
                .stream()
                .map(s -> carWheelService.findById(s))
                .collect(Collectors.toList());
        car.setCarWheels(carWheelList);
        car.setMaxSpeed(carRequestDto.getMaxSpeed());
        car.setAccelerationTime(carRequestDto.getAccelerationTime());
        car.setPassengerCapacity(carRequestDto.getPassengerCapacity());
        car.setNumberOfPassengersAtTheMoment(carRequestDto.getNumberOfPassengersAtTheMoment());
        car.setEngineType(carRequestDto.getEngineType());
        return car;
    }
}
