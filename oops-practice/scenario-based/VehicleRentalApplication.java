package VehicleRentalApplication;
import java.util.ArrayList;
import java.util.Scanner;
public class VehicleRentalApplication {
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private static void printMenu() {
        System.out.println("""
                ----------- Vehicle Rental Application -----------
                What would you like to do?

                1. Add Vehicle
                2. View Vehicles
                3. Update Vehicle
                4. Delete Vehicle
                5. Calculate Rent
                0. Exit
                -----------------------------------------------
                """);
    }
    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> viewVehicles();
                case 3 -> updateVehicle();
                case 4 -> deleteVehicle();
                case 5 -> calculateRentOnly();
                case 0 -> {
                    System.out.println("Thank you for using Vehicle Rental Application.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    //CRUD Operations
    //create
    static void addVehicle() {
        System.out.println("\nVehicle Type: 1.Bike  2.Car  3.Truck");
        int type = sc.nextInt();
        System.out.print("Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Rent per day: ");
        double rent = sc.nextDouble();

        if (type == 1) vehicles.add(new Bike(id, brand, rent));
        else if (type == 2) vehicles.add(new Car(id, brand, rent));
        else if (type == 3) vehicles.add(new Truck(id, brand, rent));
        else {
            System.out.println("Invalid vehicle type.");
            return;
        }
        System.out.println("Vehicle added successfully.\n");
    }

    //read
    static void viewVehicles() {   //view vehicles list
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.\n");
            return;
        }

        System.out.println("\nVehicle List:");
        for (Vehicle v : vehicles) {
            v.displayInfo(); //polymorphism
        }
        System.out.println();
    }

    //update
    static void updateVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available to update.\n");
            return;
        }

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                System.out.print("Enter New Brand: ");
                v.setBrand(sc.nextLine());

                System.out.print("Enter New Rent/Day: ");
                v.setRentPerDay(sc.nextDouble());

                System.out.println("Vehicle updated successfully.\n");
                return;
            }
        }
        System.out.println("Vehicle not found.\n");
    }

    //delete
    static void deleteVehicle() {  //delete vehicle
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available to delete.\n");
            return;
        }
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVehicleId() == id) {
                vehicles.remove(i);
                System.out.println("Vehicle deleted successfully.\n");
                return;
            }
        }
        System.out.println("Vehicle not found.\n");
    }
    //calculate Rent using interface method
    static void calculateRentOnly() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.\n");
            return;
        }
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Days: ");
        int days = sc.nextInt();
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                System.out.println("Total Rent = " + v.calculateRent(days) + "\n");
                return;
            }
        }
        System.out.println("Vehicle not found.\n");
        
    }
}
