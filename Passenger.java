/** 
 * Class of Passenger
*/
public class Passenger {

    // Attribute:
    public String name;

    // Accessor:
    public Passenger(String name) {
        this.name = name;
    }

    // Methods:

    /** 
    * Takes in a car that the passenger wants to go on and adds passenger, or catches exception
    * @param c The choice of car
    * @catch exception when the car is full or when the person is already on
    */

    public void boardCar(Car c) {
        try {    
            c.addPassenger(this);
        }
        catch (Exception e) {
            System.err.println(e.getMessage()); // Cannot add
        }
    }

    /** 
    * Takes in a car that the passenger wants to get off and removes passenger, or catches exception
    * @param c The choice of car
    * @catch exception when the car is empty or when the person is already off
    */

    public void getOffCar(Car c) {
        //RuntimeException when the car is empty or when the person is already off
        try {
            c.removePassenger(this);
        }
        catch (Exception e) {
            System.err.println(e.getMessage()); // Cannot remove
        }
    }
}