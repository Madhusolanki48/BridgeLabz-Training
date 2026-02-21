package app;

import model.*;
import service.TrafficService;
import exception.InvalidVehicleException;

public class SmartTrafficFineCollection {

    public static void main(String[] args) {

        TrafficService service = new TrafficService();

        try {
            // record violations
            service.recordViolation("UP32AB1234", new OverSpeedViolation());
            service.recordViolation("UP32AB1234", new SignalJumpViolation());
            service.recordViolation("DL01XY9999", new OverSpeedViolation());

            // calculate fine
            int fine = service.calculateTotalFine("UP32AB1234");
            System.out.println("Total Fine: " + fine);

            // monthly report
            service.generateMonthlyReport();

        } catch (InvalidVehicleException e) {
            System.out.println(e.getMessage());
        }
    }
}