package oops_pillars;
import java.util.*;

//interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

//abstract class
abstract class Vehicle implements GPS {
    //encapsulated fields
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;
    private String location;

    //constructor
    public Vehicle(String vehicleId,String driverName,double ratePerKm){
        this.vehicleId=vehicleId;
        this.driverName=driverName;
        this.ratePerKm=ratePerKm;
    }

    //abstract method
    public abstract double calculateFare(double distance);

    //concrete method
    public void getVehicleDetails(){
        System.out.println("Vehicle ID  : "+vehicleId);
        System.out.println("Driver Name : "+driverName);
        System.out.println("Location    : "+location);
      
    }

    //gps methods
    @Override
    public String getCurrentLocation(){
        return location;
    }
    @Override
    public void updateLocation(String newLocation){
        this.location=newLocation;
    }
}

//car
class RideCar extends Vehicle {
    public RideCar(String vehicleId,String driverName,double ratePerKm){
        super(vehicleId,driverName,ratePerKm);
    }
    @Override
    public double calculateFare(double distance){
        return ratePerKm * distance;
    }
}

//bike
class RideBike extends Vehicle {
    public RideBike(String vehicleId,String driverName,double ratePerKm){
        super(vehicleId,driverName,ratePerKm);
    }
    @Override
    public double calculateFare(double distance){
        return ratePerKm * distance * 0.9;
    }
}

//auto
class RideAuto extends Vehicle {
    public RideAuto(String vehicleId,String driverName,double ratePerKm){
        super(vehicleId,driverName,ratePerKm);
    }
    @Override
    public double calculateFare(double distance){
        return (ratePerKm * distance) + 10;
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        rides.add(new RideCar("C10671","Camren",12));
        rides.add(new RideBike("B20892","Raven",8));
        rides.add(new RideAuto("A30376","Kineley",10));

        //polymorphism
        for(Vehicle vehicle : rides){
        	vehicle.updateLocation("ABC Street");
        	vehicle.getVehicleDetails();
            System.out.println("Total Fare  : "+vehicle.calculateFare(10));
            System.out.println("------------------------------");
        }
    }
}
