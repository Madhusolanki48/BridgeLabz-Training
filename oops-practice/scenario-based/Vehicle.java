package VehicleRentalApplication;

//abstract parent class
public abstract class Vehicle implements IRentable {
	//attributes
	protected int vehicleId;
	protected String brand;
	protected double rentPerDay;
	protected boolean available = true;

	//constructor
	public Vehicle(int vehicleId, String brand, double rentPerDay) {
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.rentPerDay = rentPerDay;
	}

	//encapsulation
	//getters and setters
	public int getVehicleId() {
		return vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public double getRentPerDay() {
		return rentPerDay;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	//polymorphic method
	public abstract void displayInfo();
}
