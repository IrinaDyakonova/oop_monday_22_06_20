package hibernatehw.controllers;

import hibernatehw.dto.CarRequestDto;
import hibernatehw.dto.CarResponseDto;
import hibernatehw.mapper.CarMapper;
import hibernatehw.models.Car;
import hibernatehw.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping("/add-car")
    public String addCar(
            @RequestBody @Valid CarRequestDto carRequestDto) {
        Car car = carMapper.toEntity(carRequestDto);
        carService.add(car);

        return "car add to DB ";
    }

    @GetMapping("/all")
    public List<CarResponseDto> getAllDoor() {
        List<CarResponseDto> carResponseDtoList = carService.getAll().stream().map(car -> carMapper
                .toDto(car)).collect(Collectors.toList());
        return carResponseDtoList;
    }
}
