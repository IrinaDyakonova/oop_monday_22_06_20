package models;

import interfaces.PrintInterface;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carDoor")
public class CarDoor implements PrintInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean doorCondition;
    private boolean windowCondition;

    public CarDoor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDoorCondition() {
        return doorCondition;
    }

    public void setDoorCondition(boolean doorCondition) {
        this.doorCondition = doorCondition;
    }

    public boolean isWindowCondition() {
        return windowCondition;
    }

    public void setWindowCondition(boolean windowCondition) {
        this.windowCondition = windowCondition;
    }

    /*  public boolean isDoorCondition() {
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
    }*/

    @Override
    public String toString() {
        return "CarDoor{"
                + "door condition=" + (doorCondition ? "open" : "close")
                + ", windowCondition=" + (windowCondition ? "open" : "close")
                + '}';
    }
}
