/** 
 * Class of Engine
*/
public class Engine {

    /** 
    * Takes in information about Fuel, maxFuelLevel, and currentLevel and returns messages
    * @param inputs from user
    * @return messages about the fuel 
    */

    // Attributes:
    public static Engine engine;
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;


    // Constructors:
    //takes in initial values for the attributes named above and sets them appropriately
    public Engine(FuelType f, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = 0;
        this.maxFuelLevel = maxFuelLevel;
    }

    // Accessors:

    /** 
    * Returns information about the current fuel level of the specific engine
    * @return current fuel level
    */

    public double getCurrent(){
        return this.currentFuelLevel;
    }

    /** 
    * Returns information about the max fuel level of the specific engine
    * @return max fuel level
    */

    public double getMax(){
        return this.maxFuelLevel;
    }


    /** 
    * Refuels the tank by setting it to the max fuel
    */

    // Methods:
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }


    /** 
    * Runs the engine as long as the tank has enough fuel. 
    * Throws an exception if the tank does not have enough fuel.
    */

    public void go() {
        // decrease the current fuel level and print some useful information 
        
        this.currentFuelLevel = this.currentFuelLevel - 10;

        if (this.currentFuelLevel > 0 && this.currentFuelLevel <= this.maxFuelLevel){
            // print info
            System.out.println("Remaining fuel is " + this.currentFuelLevel);
        }

        else {
            //throw exception
            this.currentFuelLevel = this.currentFuelLevel + 10;
            throw new RuntimeException("There is not enough fuel.");
        }

    }


//main
public static void main(String[] args) {
    Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
    myEngine.refuel();
    try {
        while (true) {
            myEngine.go();
        }
    } catch (Exception e) {
        System.err.println(e.getMessage()); // Out of fuel
    }
}
}