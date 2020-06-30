package hibernatehw.dto;

public class CarDoorResponseDto {
    private Long id;
    private boolean doorCondition;
    private boolean windowCondition;

    public CarDoorResponseDto() {
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
}
