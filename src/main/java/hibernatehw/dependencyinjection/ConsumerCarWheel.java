package hibernatehw.dependencyinjection;

import hibernatehw.models.CarWheel;

@FunctionalInterface
public interface ConsumerCarWheel {

    CarWheel creatCarWheel();
}
