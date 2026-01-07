package CabBookingManagementSystem;

public class Driver {
    //attributes
    private int driverId;
    private String name;
    private boolean available = true;

    public Driver(int id, String name) {
        this.driverId = id;
        this.name = name;
    }
    //getters
    public int getId() {
    	return driverId;
    	}
    public String getName() {
    	return name;
    	}
    public boolean isAvailable() {
    	return available;
    	}
    //setters
    public void setName(String name) {
    	this.name = name;
    	}
    public void setAvailable(boolean status) {
    	this.available = status;
    	}

    @Override
    public String toString() {
        return "Driver ID: " + driverId +", Name: " + name +", Available: " + (available ? "Yes" : "No");
    }
}

