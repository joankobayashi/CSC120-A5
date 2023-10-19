import java.util.ArrayList;

/** 
 * Class of Train
*/
public class Train {

    /** 
    * Takes in information about Fuel, maxFuelLevel, number of cars, and passenger capacity and returns information
    * @param inputs about Fuel, maxFuelLevel, number of cars, and passenger capacity
    * @return information about the cars and passengers
    */

// Attributes:
    private final Engine engine;
    private ArrayList<Car> cars;
    private FuelType fuelType;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;

// • Constructor
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        //initializing the `Engine` and `Car`s and store them
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity); 
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
    }

// • Accessors / Methods:
    public Engine getEngine() {
        Engine myEngine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        return myEngine; //?
    }

    public Car getCar(int i) {
        Car myCar = new Car(nCars);
        cars.add(myCar); 
        //String carName = "";
        //carName = cars[i];
        return myCar;
    }


    public int getMaxCapacity() {
        this.passengerCapacity = this.getMaxCapacity(); //?
        return this.passengerCapacity; //the maximum total capacity across all `Car`s
    }


    public int seatsRemaining() {
        Car myCar = new Car(nCars);
        int seatsLeft = 0;
        seatsLeft += myCar.seatsRemaining();
        return seatsLeft; //the number of remaining open seats across all `Car`s
    }


    //printing 
    public void printManifest(){
        //prints a roster of all `Passenger`s onboard
        //`Car`s can help!
        System.out.println("Names of all Passengers: ");
    }


//main 
public static void main(String[] args) {
    Train myTrain = new Train(FuelType.ELECTRIC, 100., 3, 2);
    try {
        while (true) {
            myTrain.getEngine();
            myTrain.getCar(1);
            myTrain.getMaxCapacity();
            myTrain.seatsRemaining();


        }
    } catch (Exception e) {
        System.err.println(e.getMessage()); 
    }
    }  
} 