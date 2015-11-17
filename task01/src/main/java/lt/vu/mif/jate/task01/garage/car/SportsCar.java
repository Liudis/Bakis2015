package lt.vu.mif.jate.task01.garage.car;

import lt.vu.mif.jate.task01.garage.Car;

/**
 *
 * @author Martynas
 */
public class SportsCar extends Car {

    /**
     * Cars name.
     */
    private String name;

    /**
     * Construct a sports car.
     * @param input Cars name
     */
    public SportsCar(final String input) {
        name = input;
    }

    @Override
    public final String getName() {
        return name;
    }
}
