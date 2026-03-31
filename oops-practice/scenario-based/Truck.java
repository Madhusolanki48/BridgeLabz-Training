package VehicleRentalApplication;

public class Truck extends Vehicle {
	public Truck(int vehicleId, String brand, double rentPerDay) {
		super(vehicleId, brand, rentPerDay);
	}

	@Override
	public double calculateRent(int days) {
		return (rentPerDay * days) + 1000; //service charges
	}

	@Override
	public void displayInfo() {
		System.out.println("Vehicle Type: Truck | ID: " + vehicleId + " | Brand: " + brand + " | Rent/Day: " + rentPerDay
				+ " | Available: " + (available ? "Yes" : "No"));
	}
}
