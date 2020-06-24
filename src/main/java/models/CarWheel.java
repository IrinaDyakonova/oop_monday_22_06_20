package models;

import interfaces.PrintInterface;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carWheel")
public class CarWheel implements PrintInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double tireCondition;

    public CarWheel() {
        this.tireCondition = 1;
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

    /*  public void newWheel() {
        this.tireCondition = 1;
    }

    public void eraseTheTire(int percent) {
        this.tireCondition *= (1 - (double)(percent) / 100);
    }

    public double getState() {
        return this.tireCondition;
    }
    */

    @Override
    public String toString() {
        return "CarWheel{"
                + "tireCondition=" + tireCondition
                + '}';
    }
}
