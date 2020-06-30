package hibernatehw.dto;

public class CarDoorRequestDto {
    private boolean doorCondition;
    private boolean windowCondition;

    public CarDoorRequestDto() {
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
}
