package hibernatehw.mapper;

import hibernatehw.dto.CarDoorRequestDto;
import hibernatehw.dto.CarDoorResponseDto;
import hibernatehw.models.CarDoor;
import org.springframework.stereotype.Component;

@Component
public class CarDoorMapper {

    public CarDoorResponseDto toDto(CarDoor carDoor) {
        CarDoorResponseDto carDoorResponseDto = new CarDoorResponseDto();
        carDoorResponseDto.setId(carDoor.getId());
        carDoorResponseDto.setDoorCondition(carDoor.isDoorCondition());
        carDoorResponseDto.setWindowCondition(carDoor.isWindowCondition());
        return carDoorResponseDto;
    }

    public CarDoor toEntity(CarDoorRequestDto carDoorRequestDto) {
        CarDoor carDoor = new CarDoor();
        carDoor.setDoorCondition(carDoorRequestDto.isDoorCondition());
        carDoor.setWindowCondition(carDoorRequestDto.isWindowCondition());
        return carDoor;
    }
}
