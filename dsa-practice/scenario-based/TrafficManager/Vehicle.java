package TrafficManager;
import java.util.*;

public class Vehicle {   //parent class
	//attribute
	String vehicleNumber;
    // constructor
	Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String toString() {
		return vehicleNumber;
	}
}

