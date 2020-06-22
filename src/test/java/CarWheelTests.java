import models.CarWheel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarWheelTests {
    private CarWheel carWheel;

    @Before
    public void initWheel() {
        carWheel = new CarWheel();
    }

    @Test
    public void testNewWheel() {
        carWheel.newWheel();
        assertEquals(1, carWheel.getState(), 0.001);
    }

    @Test
    public void testEraseTheTire() {
        carWheel.eraseTheTire(20);
        assertEquals(0.8, carWheel.getState(), 0.001);
        carWheel.eraseTheTire(10);
        assertEquals(0.72, carWheel.getState(), 0.001);


    }

}
