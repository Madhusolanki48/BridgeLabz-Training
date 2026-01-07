package CabBookingManagementSystem;

public class Ride {
   //attributes
    private User user;
    private Driver driver;
    private double distance;
    private double fare;
    //constructor
    public Ride(User user, Driver driver, double distance, FareCalculator calc) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = calc.calculateFare(distance);
    }
    //getters
    public double getFare() {
    	return fare;
    	}
    public double getDistance() {
    	return distance;
    	}
    public Driver getDriver() {
    	return driver;
    	}
}

