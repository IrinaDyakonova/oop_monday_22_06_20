package hibernatehw.mapper;

import hibernatehw.dto.CarWheelRequestDto;
import hibernatehw.dto.CarWheelResponseDto;
import hibernatehw.models.CarWheel;
import org.springframework.stereotype.Component;

@Component
public class CarWheelMapper {

    public CarWheelResponseDto toDto(CarWheel carWheel) {
        CarWheelResponseDto carWheelResponseDto = new CarWheelResponseDto();
        carWheelResponseDto.setTireCondition(carWheel.getTireCondition());
        carWheelResponseDto.setId(carWheel.getId());
        return carWheelResponseDto;
    }

    public CarWheel toEntity(CarWheelRequestDto carWheelRequestDto) {
        CarWheel carWheel = new CarWheel();
        carWheel.setTireCondition(carWheelRequestDto.getTireCondition());
        return carWheel;
    }
}
