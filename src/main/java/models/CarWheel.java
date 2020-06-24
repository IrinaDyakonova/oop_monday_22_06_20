package models;

import interfaces.PrintInterface;

public class CarWheel implements PrintInterface {
    private double tireCondition;

    public CarWheel() {
        this.tireCondition = 1;
    }

    public void newWheel() {
        this.tireCondition = 1;
    }

    public void eraseTheTire(int percent) {
        this.tireCondition *= (1 - (double)(percent) / 100);
    }

    public double getState() {
        return this.tireCondition;
    }

    @Override
    public String toString() {
        return "CarWheel{"
                + "tireCondition=" + tireCondition
                + '}';
    }
}
