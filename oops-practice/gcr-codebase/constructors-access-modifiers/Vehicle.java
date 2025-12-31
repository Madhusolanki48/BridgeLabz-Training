package constructors_access_modifiers;
//Instance vs. Class Variables and Methods
//Problem 3: Vehicle Registration
public class Vehicle {
    private String ownerName;     // instance variable
    private String vehicleType;   // instance variable
    private static double registrationFee = 5000; // class variable
    //parameterized constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    //instance method
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("----------------------------------");
    }

    //class method
    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Maxwell", "Car");
        Vehicle vehicle2 = new Vehicle("Rony", "Bike");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6000);
        vehicle1.displayVehicleDetails();
    }
}
