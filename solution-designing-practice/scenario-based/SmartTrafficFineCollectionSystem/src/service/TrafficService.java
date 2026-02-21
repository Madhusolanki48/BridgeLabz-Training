package service;
import model.*;
import exception.InvalidVehicleException;
import java.util.*;

//business logic
public class TrafficService {

    // Map<VehicleNumber, List<Violation>>
    private Map<String, List<Violation>> violationMap = new HashMap<>();

    // record violation
    public void recordViolation(String vehicleNumber, Violation violation)
            throws InvalidVehicleException {

        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new InvalidVehicleException("Invalid vehicle number");
        }

        violationMap
                .computeIfAbsent(vehicleNumber, k -> new ArrayList<>())
                .add(violation);
    }

    //method to calculate total fine
    public int calculateTotalFine(String vehicleNumber)
            throws InvalidVehicleException {

        List<Violation> list = violationMap.get(vehicleNumber);

        if (list == null) {
            throw new InvalidVehicleException("Vehicle not found");
        }

        int total = 0;
        int count = list.size();

        for (Violation v : list) {
            total += v.calculateFine(count); // polymorphism
        }

        return total;
    }

    // monthly report
    public void generateMonthlyReport() {

        System.out.println("\n--- Monthly Traffic Fine Report ---");
        System.out.println("-------------------------------------");

        for (String vehicle : violationMap.keySet()) {
            try {
                int fine = calculateTotalFine(vehicle);
                int count = violationMap.get(vehicle).size();

                System.out.println("Vehicle Number : " + vehicle);
                System.out.println("Total Violations : " + count);
                System.out.println("Total Fine : " + fine);
                System.out.println("----------------------------------");

            } catch (InvalidVehicleException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}