package VehicleRentalApplication;

//customer class
public class Customer {
	//attributes
	private int customerId;
	private String name;
    //constructor
	public Customer(int customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}
    //getters
	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer ID: " + customerId + " | Name: " + name;
	}
}
