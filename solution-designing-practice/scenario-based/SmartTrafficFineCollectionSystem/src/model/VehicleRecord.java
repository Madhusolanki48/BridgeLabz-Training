package model;
import java.util.*;

//stores violations per vehicle
public class VehicleRecord {
	//attribute
    private String vehicleNumber;
    private List<Violation> violations = new ArrayList<>();
    //constructor
    public VehicleRecord(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void addViolation(Violation v) {
        violations.add(v);
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}