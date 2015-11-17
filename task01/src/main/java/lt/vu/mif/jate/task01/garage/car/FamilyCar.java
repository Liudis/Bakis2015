package lt.vu.mif.jate.task01.garage.car;

import lt.vu.mif.jate.task01.garage.Car;

/**
 *
 * @author Martynas
 */
public class FamilyCar extends Car {

    /**
     * Cars name.
     */
    private String name;

    /**
     * Create a family car.
     * @param input car name
     */
    public FamilyCar(final String input) {
        name = input;
    }

    @Override
    public final String getName() {
        return name;
    }
}
