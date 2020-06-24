package models;

import dependencyinjection.ConsumerCarWheel;
import interfaces.PrintInterface;
import java.time.LocalDate;
import java.util.Arrays;
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
    private CarDoor[] carDoors;
    @OneToMany
    private CarWheel[] carWheels;

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

    public CarDoor[] getCarDoors() {
        return carDoors;
    }

    public void setCarDoors(CarDoor[] carDoors) {
        this.carDoors = carDoors;
    }

    public CarWheel[] getCarWheels() {
        return carWheels;
    }

    public void setCarWheels(CarWheel[] carWheels) {
        this.carWheels = carWheels;
    }

    /*  public Car(
                        LocalDate dateOfManufacture,
                        String engineType,
                        double maxSpeed,
                        int numberOfDoor,
                        int passengerCapacity) {
                    this.dateOfManufacture = dateOfManufacture;
                    this.engineType = engineType;
                    this.carDoors = new CarDoor[numberOfDoor];
                    this.carWheels = new CarWheel[4];
                    for (int i = 0; i < carWheels.length; i++) {
                        carWheels[i] = creatCarWheel();
                    }
                    Random random = new Random();
                    this.maxSpeed = maxSpeed;
                    this.accelerationTime = random.nextInt(10) + 5;
                    this.passengerCapacity = passengerCapacity;
                    this.numberOfPassengersAtTheMoment = 0;
                }

                public void changeCurrentSpeed(double speed) {
                    this.speedAtTheMoment = speed <= 0
                            ? 0 : speed <= maxSpeedAtTheMoment()
                            ? speed : maxSpeedAtTheMoment();
                }

                public double getSpeedAtTheMoment() {
                    return speedAtTheMoment;
                }

                public int getNumberOfPassengersAtTheMoment() {
                    return numberOfPassengersAtTheMoment;
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
                    return this.carDoors[index];
                }

                public CarWheel gerWheelFromIndex(int index) {
                    return this.carWheels[index];
                }

                public void dropAllWheel() {
                    this.carWheels = new CarWheel[0];
                }

                public int getCountOfWheels() {

                    return carWheels.length;
                }

                public void addNewWheel(int count) {
                    int newCountWheel = carWheels == null ? count : carWheels.length + count;
                    CarWheel[] newCarWheels = new CarWheel[newCountWheel];
                    int i = 0;
                    if (this.carWheels != null) {
                        for (; i < this.carWheels.length; i++) {
                            newCarWheels[i] = this.carWheels[i];
                        }
                    }
                    for (; i < newCarWheels.length; i++) {
                        newCarWheels[i] = creatCarWheel();
                        newCarWheels[i].newWheel();
                    }

                    this.carWheels = newCarWheels;
                }

                public double maxSpeedAtTheMoment() {
                    if (this.numberOfPassengersAtTheMoment == 0) {
                        return 0;
                    }
                    double maxWheelWear = 0;
                    if (this.carWheels.length > 0) {
                        maxWheelWear = carWheels[0].getState();
                        for (int i = 1; i < carWheels.length; i++) {
                            if (carWheels[i].getState() < maxWheelWear) {
                                maxWheelWear = carWheels[i].getState();
                            }
                        }
                    }
                    return (maxSpeed * maxWheelWear);
                }
            */
    @Override
    public String toString() {
        return "Car{"
                + "dateOfManufacture=" + dateOfManufacture
                + ", engineType='" + engineType + '\''
                + ", accelerationTime=" + accelerationTime
                + ", passengerCapacity=" + passengerCapacity
                + ", numberOfPassengersAtTheMoment=" + numberOfPassengersAtTheMoment
                + ", speedAtTheMoment=" + speedAtTheMoment
                + ", carDoors=" + Arrays.toString(carDoors)
                + ", carWheels=" + Arrays.toString(carWheels)
                + '}';
    }

    @Override
    public CarWheel creatCarWheel() {
        return new CarWheel();
    }
}
