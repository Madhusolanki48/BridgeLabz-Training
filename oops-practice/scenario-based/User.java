package CabBookingManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
    private String name;
    private List<Ride> rideHistory = new ArrayList<>();
    //constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //getters
    public int getId() {
    	return id;
    	}
    public String getName() {
    	return name;
    	}
    //setters
    public void setName(String name) {
    	this.name = name;
    	}
    public void addRide(Ride r) {
        rideHistory.add(r);
    }
    //method to print ride history
    public void printRideHistory() {
        System.out.println("\nRide History of " + name + ":");
        if (rideHistory.isEmpty()) {
            System.out.println("No rides yet.");
            return;
        }
        for (Ride r : rideHistory) {
            System.out.println("Driver: " + r.getDriver().getName() +", Distance: " + r.getDistance() +" km, Fare: " + r.getFare());
        }
    }
    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + name;
    }
}

