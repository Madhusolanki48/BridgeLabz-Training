package AddressBook;

//UC-1: Create Contact (Model Class) 
public class Contact {
	//attributes
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String email;

	//constructor
	public Contact(String firstName, String lastName, String address, String city,
			String state, String zipCode, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;

	}

	//getter method
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getPhone() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "\n--------------- Contact Details ---------------" +
				"\nName        : " + firstName + " " + lastName +
				"\nAddress     : " + address +
				"\nCity/State  : " + city + ", " + state +
				"\nZip         : " + zipCode +
				"\nPhone       : " + phoneNumber +
				"\nEmail       : " + email +
				"\n----------------------------------------------";
	}
}
