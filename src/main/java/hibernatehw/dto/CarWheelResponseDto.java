package hibernatehw.dto;

public class CarWheelResponseDto {
    private Long id;
    private double tireCondition;

    public CarWheelResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTireCondition() {
        return tireCondition;
    }

    public void setTireCondition(double tireCondition) {
        this.tireCondition = tireCondition;
    }
}
