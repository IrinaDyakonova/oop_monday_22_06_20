package dependencyinjection;

import models.CarWheel;

@FunctionalInterface
public interface ConsumerCarWheel {

    CarWheel creatCarWheel();
}
