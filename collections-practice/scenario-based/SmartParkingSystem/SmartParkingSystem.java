package SmartParkingSystem;

public class SmartParkingSystem {

    public static void main(String[] args) {
    	System.out.println("----------------------------------");
		System.out.println("   PARKING SLOT ALLOCATION");
		System.out.println("----------------------------------");

        ParkingManager manager = new ParkingManager();

        manager.addSlot(new ParkingSlot(1));
        manager.addSlot(new ParkingSlot(2));

        manager.addVehicle(new Car("CAR123"));
        manager.addVehicle(new Bike("BIKE456"));

        try {
            manager.allocateSlot();
            manager.allocateSlot();
            manager.allocateSlot(); //triggers exception
        } catch (NoParkingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
