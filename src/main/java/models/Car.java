package models;

import interfaces.PrintInterface;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Car implements PrintInterface {
    private final LocalDate dateOfManufacture;
    private final String engineType;
    private final double maxSpeed;
    private final double accelerationTime;
    private final int passengerCapacity;
    private int numberOfPassengersAtTheMoment;
    private double speedAtTheMoment;
    private final CarDoor[] carDoors;
    private CarWheel[] carWheels;

    public Car(LocalDate dateOfManufacture, String engineType, double maxSpeed) {
        this.dateOfManufacture = dateOfManufacture;
        this.engineType = engineType;
        this.carDoors = new CarDoor[4];
        this.carWheels = new CarWheel[4];
        for (int i = 0; i < carWheels.length; i++) {
            carWheels[i] = new CarWheel();
        }
        Random random = new Random();
        this.maxSpeed = maxSpeed;
        this.accelerationTime = random.nextInt(10) + 5;
        this.passengerCapacity = random.nextInt(5) + 1;
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
            newCarWheels[i] = new CarWheel();
            newCarWheels[i].newWheel();
        }

        this.carWheels = newCarWheels;
    }

    public double maxSpeedAtTheMoment() {
        if (this.numberOfPassengersAtTheMoment == 0) {
            return 0;
        }
        double min = 0;
        if (this.carWheels.length > 0) {
            min = carWheels[0].getState();
            for (int i = 1; i < carWheels.length; i++) {
                if (carWheels[i].getState() < min) {
                    min = carWheels[i].getState();
                }
            }
        }
        return (maxSpeed * min);
    }

    @Override
    public String toString() {
        return "Car{"
                + "dateOfManufacture=" + dateOfManufacture
                + ", engineType='" + engineType + '\''
                + ", maxSpeedAtTheMoment=" + maxSpeedAtTheMoment()
                + ", accelerationTime=" + accelerationTime
                + ", passengerCapacity=" + passengerCapacity
                + ", numberOfPassengersAtTheMoment=" + numberOfPassengersAtTheMoment
                + ", speedAtTheMoment=" + speedAtTheMoment
                + ", carDoors=" + Arrays.toString(carDoors)
                + ", carWheels=" + Arrays.toString(carWheels)
                + '}';
    }
}