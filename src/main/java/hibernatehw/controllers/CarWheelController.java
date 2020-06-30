package hibernatehw.controllers;

import hibernatehw.dto.CarWheelRequestDto;
import hibernatehw.dto.CarWheelResponseDto;
import hibernatehw.mapper.CarWheelMapper;
import hibernatehw.models.CarWheel;
import hibernatehw.service.CarWheelService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wheels")
public class CarWheelController {
    private final CarWheelService carWheelService;
    private final CarWheelMapper carWheelMapper;

    public CarWheelController(CarWheelService carWheelService, CarWheelMapper carWheelMapper) {
        this.carWheelService = carWheelService;
        this.carWheelMapper = carWheelMapper;
    }

    @PostMapping("/add-wheel")
    public String addWheel(
            @RequestBody @Valid CarWheelRequestDto carWheelRequestDto) {
        CarWheel carWheel = carWheelMapper.toEntity(carWheelRequestDto);
        carWheelService.add(carWheel);

        return "carWheel add to DB ";
    }

    @GetMapping("/all")
    public List<CarWheelResponseDto> getAllWheel() {
        List<CarWheelResponseDto> carWheelResponseDtoList = carWheelService
                .getAll()
                .stream()
                .map(carWheel -> carWheelMapper
                .toDto(carWheel))
                .collect(Collectors.toList());
        return carWheelResponseDtoList;
    }
}
