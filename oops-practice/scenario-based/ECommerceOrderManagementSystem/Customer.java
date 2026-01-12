package ECommerceOrderManagementSystem;

public class Customer {
	private int customerId;
	private String customerName;
	private String phoneNumber;
	
	//constructor
	public Customer(int customerId,String customerName,String phoneNumber) {
		this.customerId=customerId;
		this.customerName=customerName;
		this.phoneNumber=phoneNumber;
		
	}
	//getters
	public int getId() {
		return customerId;
		
	}
	public String getName() {
		return customerName;
		
	}
	public String getPhone() {
		return phoneNumber;
	}
	public String toString() {
		return "Customer details: "+"Cutomer's Id - "+customerId+" | Cutomer's Name - "+customerName+" | Contact Number - "+phoneNumber;
	}

}
