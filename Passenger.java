/** 
 * Class of Passenger
*/
public class Passenger {
    
    /** 
    * Takes in passenger and returns added or removed list
    * @param Car
    * @return added or removed list
    */

    public String name;

    public Passenger(String name) {
        this.name = name;
    }



// Methods:
    public void boardCar(Car c) {

        //calling the c.addPassenger(...) method and catching the 
        //RuntimeException when the car is full or when the person is already on
        try {
            c.addPassenger(this);
        }
        catch (Exception e) {
            System.err.println(e.getMessage()); // Cannot add
        }

    }


    public void getOffCar(Car c) {
    
        //calling the c.removePassenger(...) method and catching the 
        //RuntimeException when the car is empty or when the person is already off
        try {
            c.removePassenger(this);
        }
        catch (Exception e) {
            System.err.println(e.getMessage()); // Cannot remove
        }
        
    
    }
}