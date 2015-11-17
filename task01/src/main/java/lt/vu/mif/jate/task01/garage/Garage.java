package lt.vu.mif.jate.task01.garage;


import java.util.Calendar;
import lt.vu.mif.jate.task01.garage.car.Bus;
import lt.vu.mif.jate.task01.garage.car.FamilyCar;
import lt.vu.mif.jate.task01.garage.car.SportsCar;

/**
*
* @author Martynas
*/
public class Garage {

   /**
    * Array of cars.
    */
   private Car[] carz;
   /**
    * Cars in use.
    */
   private int used;
   /**
    * Weekday starts from 1.
    */
   private static final int WEEKDAY_START_DAY = 1;
   /**
    * Weekday ends from 7.
    */
   private static final int WEEKDAY_END_DAY = 7;

   /**
    * Crate garage of a set size.
    * @param input garage size
    */
   public Garage(final int input) {
       carz = new Car[input];
       used = 0;
   }

   /**
    * Add a car to garage. Can't overflow.
    * Doesn't tell you if cars are overflowing.
    * @param input car to put in garage
    */
   public final void add(final Car input) {
       for (int i = 0; i < carz.length; i++) {
           if (carz[i] == null) {
               carz[i] = input;
               used++;
               break;
           }
       }
   }

   /**
    * Pick a car from garage using date logic.
    * Family car for weekdays.
    * Sports car for weekends.
    * @param input calendar day
    * @return a car
    */
   public final Car pickACar(final Calendar input) {
       int weekDay = input.get(Calendar.DAY_OF_WEEK);
       Car output = null;
       for (Car car : carz) {
           if (output == null && car != null) {
               output = car;
           }
           if (car != null && weekDay > WEEKDAY_START_DAY
                   && weekDay < WEEKDAY_END_DAY) {
               if (car instanceof FamilyCar) {
                   return car;
               }
           } else {
               if (car instanceof SportsCar) {
                   return car;
               }
           }
       }
       if (output == null && weekDay > WEEKDAY_START_DAY
               && weekDay < WEEKDAY_END_DAY) {
           return new Bus();
       }
       return output;
   }

   /**
    * Pick a car from garage using date logic.
    * Family car for weekdays.
    * Sports car for weekends.
    * @return a car
    */
   public final Car pickACar() {
       return pickACar(Calendar.getInstance());
   }

   /**
    * Remove cars from garage.
    */
   public final void removeAll() {
       for (int i = 0; i < carz.length; i++) {
           carz[i] = null;
       }
       used = 0;
   }

   /**
    * Tells you how many spaces in garage is left.
    * @return spaces in garage is left.
    */
   public final int getFreePlaces() {
       return carz.length - used;
   }

   /**
    * Tells you how large the garage is.
    * @return garage size
    */
   public final int getSize() {
       return carz.length;
   }

   /**
    * Tells you how many garage spaces are being used.
    * @return number of garage spaces are being used
    */
   public final int getCount() {
       return used;
   }

   /**
    * Returns a car in specified garage slot.
    * @param input garage slot
    * @return car
    */
   public final Car get(final int input) {
       if (input > 0 && input <= carz.length) {
           return carz[input - 1];
       }
       return null;
   }

   /**
    * Removes the car from specified slot.
    * @param input car slot
    * @return removed car
    */
   public final Car remove(final int input) {
       Car  output = null;
       if (input > 0 && input <= carz.length && carz[input - 1] != null) {
           output = carz[input - 1];
           carz[input - 1] = null;
           used--;
       }
       return output;
   }

   /**
    * If specific car exist remove it from garage.
    * @param input specific car
    * @return removed car
    */
   public final Car remove(final Car input) {
       Car  output = null;
       for (int i = 0; i < carz.length; i++) {
           if (carz[i] != null) {
               if (carz[i].equals(input)) {
                   output = carz[i];
                   carz[i] = null;
                   used--;
               }
           }
       }
       return output;
   }
}
