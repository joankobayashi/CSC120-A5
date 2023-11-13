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


    // Constructor:
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        //initializing the `Engine` and `Car`s and store them
        this.engine = new Engine(fuelType, fuelCapacity); 
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++){
            Car newCar = new Car(passengerCapacity);
            cars.add(newCar);
        }
    }


    // Accessors:

    /** 
    * Returns the engine type
    * @return engine type 
    */

    public Engine getEngine() {
        return this.engine; 
    }

    /** 
    * Returns the ith car in the train
    * @return the ith car 
    */

    public Car getCar(int i) {
        Car carNum = this.cars.get(i);
        return carNum;
    }

    /** 
    * Returns the maximum capacity of all cars
    * @return max capacity across all cars
    */

    public int getMaxCapacity() {
        int maxCap = 0;
        for (int i = 0; i < cars.size(); i++) {
            maxCap += getCar(i).getCapacity();
        }
        return maxCap; //the maximum total capacity across all `Car`s
    }

    /** 
    * Returns the number of remaining seats across all cars
    * @return seats remaining across all cars
    */

    public int seatsRemaining() {
        int seatsLeft = 0;
        for (int i = 0; i < cars.size(); i++) {
            seatsLeft += getCar(i).seatsRemaining();
        }
        return seatsLeft; //the number of remaining open seats across all `Car`s
    }

    /** 
    * Prints the roster of passengers on board
    */
    
    public void printManifest(){
        
        System.out.println("\nNames of all Passengers: ");
        //`Car`s can help!
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + i + ": ");
            getCar(i).printManifest();
        }
    }


//main 
public static void main(String[] args) {
    Train myTrain = new Train(FuelType.ELECTRIC, 100., 3, 2);
    try {
            myTrain.getEngine();
            Car myCar = myTrain.getCar(1);
            myTrain.getMaxCapacity();
            Passenger p = new Passenger("Joan");
            Passenger s = new Passenger("Sofia");
            myCar.addPassenger(p);
            myCar.addPassenger(s);
            myCar.printManifest();
            myCar.removePassenger(p);
            myCar.printManifest();

            myTrain.printManifest();
    } catch (Exception e) {
        System.err.println(e.getMessage()); 
    }
    }  
} 