package oops_pillars;
import java.util.*;

//interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

//abstract class
abstract class Vehicle implements Insurable {
    //encapsulated fields
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    //constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    //abstract method
    public abstract double calculateRentalCost(int days);

    //concrete method
    public void displayVehicle(int days) {
        System.out.println("Vehicle No  : " + vehicleNumber);
        System.out.println("Type        : " + type);
        System.out.println("Rental Cost : " + calculateRentalCost(days));
        System.out.println("Insurance   : " + calculateInsurance());
        System.out.println("------------------------------");
    }

    //getters
    public String getVehicleNumber() {
    	return vehicleNumber;
    	}
}

//car rental
class CarRental extends Vehicle {
    public CarRental(String vehicleNumber, String type, double rentalRate) {
    	super(vehicleNumber,type,rentalRate);
    	}
    @Override
    public double calculateRentalCost(int days) {
    	return rentalRate * days;
    	}
    @Override
    public double calculateInsurance() {
    	return 2000;
    	}
    @Override
    public String getInsuranceDetails() {
    	return "Standard Car Insurance";
    	}
}

//bike rental
class BikeRental extends Vehicle {
    public BikeRental(String vehicleNumber, String type, double rentalRate) {
    	super(vehicleNumber,type,rentalRate);
    	}
    @Override
    public double calculateRentalCost(int days) {
    	return rentalRate * days;
    	}
    @Override
    public double calculateInsurance() {
    	return 800;
    	}
    @Override
    public String getInsuranceDetails() {
    	return "Two Wheeler Insurance";
    	}
}

//truck rental
class TruckRental extends Vehicle{
    public TruckRental(String vehicleNumber, String type, double rentalRate) { 
    	super(vehicleNumber,type,rentalRate);
    	}
    @Override
    public double calculateRentalCost(int days) {
    	return rentalRate * days + 3000;  //extra charges
    	} 
    @Override
    public double calculateInsurance() {
    	return 4000;
    	}
    @Override
    public String getInsuranceDetails() {
    	return "Commercial Insurance";
    	}
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new CarRental("UPFG67833","Car",1500));
        list.add(new BikeRental("UP54GSYUU","Bike",500));
        list.add(new TruckRental("MPTY37383","Truck",3000));

        //polymorphism
        for(Vehicle v : list) {
            v.displayVehicle(3);
        }
    }
}
