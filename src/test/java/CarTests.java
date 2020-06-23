import java.time.LocalDate;
import java.util.Random;
import models.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTests {
    private static final double DELTA = 0.001;
    private double speed;
    private Car car;

    @Before
    public void initCar() {
        Random random = new Random();
        speed = random.nextInt(100) + 100;
        car = new Car(LocalDate.of(2020,5,20), "gas", speed);
    }

    @Test
    public void testAddPassenger() {
        car.addPassengerInTheCar();
        assertEquals(1, car.getNumberOfPassengersAtTheMoment());
    }

    @Test
    public void testDropPassenger() {
        car.dropOffPassenger();
        assertEquals(0, car.getNumberOfPassengersAtTheMoment());
    }

    @Test
    public void testDropAllPassengers() {
        car.addPassengerInTheCar();
        car.addPassengerInTheCar();
        car.addPassengerInTheCar();
        car.dropAllPassengers();
        assertEquals(0, car.getNumberOfPassengersAtTheMoment());
    }

    @Test
    public void testDropAllWheels() {
        car.dropAllWheel();
        assertEquals(0, car.getCountOfWheels());
    }

    @Test
    public void addNewWheel() {
        car.addNewWheel(3);
        assertEquals(7, car.getCountOfWheels());
    }

    @Test
    public void testChangeCurrentSpeed() {
        car.changeCurrentSpeed(-5);
        assertEquals(0, car.getSpeedAtTheMoment(), DELTA);
        car.addPassengerInTheCar();
        car.changeCurrentSpeed(5);
        assertEquals(5, car.getSpeedAtTheMoment(), DELTA);
        car.changeCurrentSpeed(15);
        assertEquals(15, car.getSpeedAtTheMoment(), DELTA);

    }
}
