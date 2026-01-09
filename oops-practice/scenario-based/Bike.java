package VehicleRentalApplication;

public class Bike extends Vehicle {
	public Bike(int vehicleId, String brand, double rentPerDay) {
		super(vehicleId, brand, rentPerDay);
	}

	@Override
	public double calculateRent(int days) {
		return rentPerDay * days;
	}

	@Override
	public void displayInfo() {
		System.out.println("Vehicle Type: Bike  | ID: " + vehicleId + " | Brand: " + brand + " | Rent/Day: " + rentPerDay
				+ " | Available: " + (available ? "Yes" : "No"));
	}
}
