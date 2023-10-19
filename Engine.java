import java.util.Scanner;

/** 
 * Class of Engine
*/
public class Engine {

    /** 
    * Takes in information about Fuel, maxFuelLevel, and currentLevel and returns messages
    * @param inputs from user
    * @return messages about the fuel 
    */

    public static Engine engine;
    // Attributes:
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;


// • Constructor
    //takes in initial values for the attributes named above and sets them appropriately
    public Engine(FuelType f, double maxFuelLevel, double currentFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

// • Methods:
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }

    Scanner input = new Scanner(System.in);

    public void go() {
        // decrease the current fuel level and print some useful information 
        System.out.println("How far do you want to go:");
        double distance = input.nextDouble();

        this.currentFuelLevel = this.currentFuelLevel - distance;

        if (this.currentFuelLevel >= 0 && distance <= this.maxFuelLevel){
            // print info
            System.out.println("Remaining fuel is " + this.currentFuelLevel);
        }

        else {
            //throw exception
            this.currentFuelLevel = this.currentFuelLevel + distance;
            throw new RuntimeException("There is not enough fuel.");
            
        }

    }


//main
public static void main(String[] args) {
    Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 0.0);
    try {
        while (true) {
            myEngine.refuel();
            myEngine.go();
        }
    } catch (Exception e) {
        System.err.println(e.getMessage()); // Out of fuel
    }
}
}