package VehicleRentalApplication;

public class Car extends Vehicle {
	public Car(int vehicleId, String brand, double rentPerDay) {
		super(vehicleId, brand, rentPerDay);
	}

	@Override
	public double calculateRent(int days) {
		return (rentPerDay * days) + 500; //service charges
	}

	@Override
	public void displayInfo() {
		System.out.println("Vehicle Type: Car   | ID: " + vehicleId + " | Brand: " + brand + " | Rent/Day: " + rentPerDay
				+ " | Available: " + (available ? "Yes" : "No"));
	}
}
