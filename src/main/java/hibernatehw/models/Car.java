package hibernatehw.models;

import hibernatehw.dependencyinjection.ConsumerCarWheel;
import hibernatehw.interfaces.PrintInterface;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car implements PrintInterface, ConsumerCarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfManufacture;
    private String engineType;
    private double maxSpeed;
    private double accelerationTime;
    private int passengerCapacity;
    private int numberOfPassengersAtTheMoment;
    private double speedAtTheMoment;
    @OneToMany
    private List<CarDoor> carDoors;
    @OneToMany
    private List<CarWheel> carWheels;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
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

    public List<CarDoor> getCarDoors() {
        return carDoors;
    }

    public void setCarDoors(List<CarDoor> carDoors) {
        this.carDoors = carDoors;
    }

    public List<CarWheel> getCarWheels() {
        return carWheels;
    }

    public void setCarWheels(List<CarWheel> carWheels) {
        this.carWheels = carWheels;
    }

    public void changeCurrentSpeed(double speed) {
        this.speedAtTheMoment = speed <= 0
             ? 0 : speed <= maxSpeedAtTheMoment()
             ? speed : maxSpeedAtTheMoment();
    }

    public void addPassengerInTheCar() {
        if (this.numberOfPassengersAtTheMoment + 1 <= this.passengerCapacity) {
            this.numberOfPassengersAtTheMoment++;
        }
    }

    public void dropOffPassenger() {
        if (this.numberOfPassengersAtTheMoment - 1 >= 0) {
            this.numberOfPassengersAtTheMoment--;
        }
    }

    public void dropAllPassengers() {
        this.numberOfPassengersAtTheMoment = 0;
    }

    public CarDoor getDoorFromIndex(int index) {
        return carDoors.get(index);
    }

    public CarWheel gerWheelFromIndex(int index) {
        return carWheels.get(index);
    }

    public void dropAllWheel() {
        carWheels.clear();
    }

    public int getCountOfWheels() {

        return carWheels.size();
    }

    public void addNewWheel(int count) {
        int i = 0;
        for (; i < count; i++) {
            carWheels.add(creatCarWheel());
        }

    }

    public double maxSpeedAtTheMoment() {
        if (this.numberOfPassengersAtTheMoment == 0) {
            return 0;
        }
        double maxWheelWear = 0;
        if (this.carWheels.size() > 0) {
            maxWheelWear = carWheels.get(0).getTireCondition();
            for (int i = 1; i < carWheels.size(); i++) {
                if (carWheels.get(i).getTireCondition() < maxWheelWear) {
                    maxWheelWear = carWheels.get(i).getTireCondition();
                }
            }
        }
        return (maxSpeed * maxWheelWear);
    }

    @Override
    public String toString() {
        return "Car{"
                + "dateOfManufacture=" + dateOfManufacture
                + ", engineType='" + engineType + '\''
                + ", accelerationTime=" + accelerationTime
                + ", passengerCapacity=" + passengerCapacity
                + ", numberOfPassengersAtTheMoment=" + numberOfPassengersAtTheMoment
                + ", speedAtTheMoment=" + speedAtTheMoment
                + ", carDoors=" + carDoors.stream().map(carDoor -> carDoor.toString()).toArray()
                + ", carWheels=" + carWheels.stream().map(carDoor -> carDoor.toString()).toArray()
                + '}';
    }

    @Override
    public CarWheel creatCarWheel() {
        return new CarWheel();
    }
}
