import java.util.ArrayList;

/** 
* Class of Car
*/
public class Car {

    /** 
    * Attributes: An ArrayList of passengers and a number of max capacity
    */
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    
    // Constructor
    public Car(int maxCapacity){
        // takes in an initial value for the `Car`'s maximum capacity
        this.maxCapacity = maxCapacity;
        // initializes an appropriately-sized `ArrayList`
        this.passengersOnboard = new ArrayList<Passenger>();
    }


    /** 
    * Returns the maximum capacity
    * @return max capacity 
    */

    // Accessor-like methods:
    public int getCapacity(){
        //System.out.println(this.maxCapacity);
        return this.maxCapacity;
    }

    /** 
    * Returns the number of seats left
    * @return number of seats left 
    */

    public int seatsRemaining(){
        int arraySize = this.passengersOnboard.size();
        int seatsLeft = this.maxCapacity - arraySize;
        System.out.println(seatsLeft);
        return seatsLeft;
    }


    /** 
    * Inputs the passenger to the Arraylist, if they are not on the list
    * @param p Passenger input by the user  
    */

    // Methods:
    public void addPassenger(Passenger p) {
        
        if (this.passengersOnboard.contains(p)){
            throw new RuntimeException(p.name + " is already on board.");
        }
        
        else if (seatsRemaining() != 0 ){ //check that there are seats available
            //adds p
            this.passengersOnboard.add(p);
            System.out.println("Adding " + p.name + "...");
        }
    }

    /** 
    * Take in the passenger and removes the name from the Arraylist, if they are on the list
    * @param p  Passenger input by the user
    */

    public void removePassenger(Passenger p) {
        //confirming that the `Passenger` is actually onboard before trying to remove
        if (this.passengersOnboard.contains(p)){
            //removing
            this.passengersOnboard.remove(p);
            System.out.println("Removing " + p.name + "...");
        }

        else {
            //If you encounter a problem, throw a `RuntimeException`
            throw new RuntimeException(p.name + " is not on board.");
        }
    }

    /** 
    * Take in the passenger and removes the name from the Arraylist
    * @param p  Passenger input by the user
    */
    
    public void printManifest() {
        int arraySize = this.passengersOnboard.size();
        if (arraySize == 0){
            System.out.println("This car is EMPTY.");
        }

        else {
            // want to make it a list and not an arraylist 
            String fullList = new String();
            
            if (arraySize > 1){
                for (Passenger str : this.passengersOnboard) { 
                    fullList += (str.name + ", ");
                }  
                fullList = fullList.substring(0, fullList.length()-2) + ".";
                System.out.println("The people on board are: " + fullList);
            }

            else {
                for (Passenger str : this.passengersOnboard) { 
                    fullList = (str.name);
                }
                System.out.println("The person on board is: " + fullList + ".");
            }
        }
    }


//main
public static void main(String[] args) {
    Car myCar = new Car(10);
    try {
        while (true) {
            Passenger p = new Passenger("Joan");
            Passenger s = new Passenger("Sofia");
            myCar.addPassenger(p);
            myCar.addPassenger(s);
            myCar.printManifest();
            myCar.removePassenger(p);
            myCar.printManifest();
            
            break;
        }
    } catch (Exception e) {
        System.err.println(e.getMessage()); 
    }
}
}