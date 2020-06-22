import models.CarDoor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarDoorTests {

    private CarDoor carDoor;

    @Before
    public void initCarDoor() {
        carDoor = new CarDoor();
    }

    @Test
    public void testOpenDoor() {
        carDoor.openDoor();
        assertTrue(carDoor.isDoorCondition());
    }
    @Test
    public void testCloseDoor() {
        carDoor.closeDoor();
        assertFalse(carDoor.isDoorCondition());
    }

    @Test
    public void testToggleDoor() {
        carDoor.toggleDoor();
        assertTrue(carDoor.isDoorCondition());
        carDoor.toggleDoor();
        assertFalse(carDoor.isDoorCondition());
    }

    @Test
    public void testOpenWindow() {
        carDoor.openWindow();
        assertTrue(carDoor.isWindowCondition());
    }
    @Test
    public void testCloseWindow() {
        carDoor.closeWindow();
        assertFalse(carDoor.isWindowCondition());
    }

    @Test
    public void testToggleWindow() {
        carDoor.toggleWindow();
        assertTrue(carDoor.isWindowCondition());
        carDoor.toggleWindow();
        assertFalse(carDoor.isWindowCondition());
    }

}
