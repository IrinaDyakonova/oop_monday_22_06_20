package hibernatehw.controllers;

import hibernatehw.dto.CarDoorRequestDto;
import hibernatehw.dto.CarDoorResponseDto;
import hibernatehw.mapper.CarDoorMapper;
import hibernatehw.models.CarDoor;
import hibernatehw.service.CarDoorService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doors")
public class CarDoorController {
    private final CarDoorService carDoorService;
    private final CarDoorMapper carDoorMapper;

    public CarDoorController(CarDoorService carDoorService, CarDoorMapper carDoorMapper) {
        this.carDoorService = carDoorService;
        this.carDoorMapper = carDoorMapper;
    }

    @PostMapping("/add-door")
    public String addDoor(
            @RequestBody @Valid CarDoorRequestDto carDoorRequestDto) {
        CarDoor carDoor = carDoorMapper.toEntity(carDoorRequestDto);
        carDoorService.add(carDoor);

        return "carDoor add to DB ";
    }

    @GetMapping("/all")
    public List<CarDoorResponseDto> getAllDoor() {
        List<CarDoorResponseDto> carDoorResponseDtoList = carDoorService
                .getAll()
                .stream()
                .map(carDoor -> carDoorMapper
                .toDto(carDoor))
                .collect(Collectors.toList());
        return carDoorResponseDtoList;
    }
}
