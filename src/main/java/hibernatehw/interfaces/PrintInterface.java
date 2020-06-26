package hibernatehw.interfaces;

public interface PrintInterface {
    default void printObjectData() {
        System.out.println(toString());
    }
}
