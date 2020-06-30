package hibernatehw.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CarResponseDto {
    private Long id;
    private LocalDateTime dateOfManufacture;
    private String engineType;
    private double maxSpeed;
    private double accelerationTime;
    private int passengerCapacity;
    private int numberOfPassengersAtTheMoment;
    private double speedAtTheMoment;
    private List<Long> doorId;
    private List<Long> wheelId;

    public CarResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDateTime dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getNumberOfPassengersAtTheMoment() {
        return numberOfPassengersAtTheMoment;
    }

    public void setNumberOfPassengersAtTheMoment(int numberOfPassengersAtTheMoment) {
        this.numberOfPassengersAtTheMoment = numberOfPassengersAtTheMoment;
    }

    public double getSpeedAtTheMoment() {
        return speedAtTheMoment;
    }

    public void setSpeedAtTheMoment(double speedAtTheMoment) {
        this.speedAtTheMoment = speedAtTheMoment;
    }

    public List<Long> getDoorId() {
        return doorId;
    }

    public void setDoorId(List<Long> doorId) {
        this.doorId = doorId;
    }

    public List<Long> getWheelId() {
        return wheelId;
    }

    public void setWheelId(List<Long> wheelId) {
        this.wheelId = wheelId;
    }
}
