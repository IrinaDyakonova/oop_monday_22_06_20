package models;

import interfaces.PrintInterface;

public class CarDoor implements PrintInterface {
    private boolean doorCondition;
    private boolean windowCondition;

    public boolean isDoorCondition() {
        return doorCondition;
    }

    public boolean isWindowCondition() {
        return windowCondition;
    }

    public void openDoor() {
        this.doorCondition = true;
    }

    public void closeDoor() {
        this.doorCondition = false;
    }

    public void toggleDoor() {
        this.doorCondition = !this.doorCondition;
    }

    public void openWindow() {
        this.windowCondition = true;
    }

    public void closeWindow() {
        this.windowCondition = false;
    }

    public void toggleWindow() {
        this.windowCondition = !this.windowCondition;
    }

    @Override
    public String toString() {
        return "CarDoor{"
                + "door condition=" + (doorCondition ? "open" : "close")
                + ", windowCondition=" + (windowCondition ? "open" : "close")
                + '}';
    }
}
