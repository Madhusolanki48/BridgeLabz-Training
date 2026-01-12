package HotelReservationSystem;

//guest class
public class Guest {
	//attributes
	private int guestId;
	private String name;
	private String phone;

	//constructor
	public Guest(int guestId, String name, String phone) {
		this.guestId = guestId;
		this.name = name;
		this.phone = phone;
	}

	//getters
	public int getId() {
		return guestId;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Guest Details: " + "Id - " + guestId + " | Name - " + name + " | Phone - " + phone;
	}
}
