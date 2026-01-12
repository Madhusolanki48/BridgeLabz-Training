package HotelReservationSystem;
//room class
public class Room {
	//attributes
	private int roomNumber;
	private double basePrice;
	private boolean available;

	//constructor
	public Room(int roomNumber, double basePrice) {
		this.roomNumber = roomNumber;
		this.basePrice = basePrice;
		this.available = true;
	}

	//getters
	public int getRoomNumber() {
		return roomNumber;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public boolean isAvailable() {
		return available;
	}

	//setter
	public void setAvailable(boolean available) {
		this.available = available;
	}

	//method to get room type
	public String getRoomType() {
		return "Room";
	}

	@Override
	public String toString() {
		return "Room Details: " + "Room No - " + roomNumber + " | Type - " + getRoomType() + " | Base Price - "
				+ basePrice + " | Available - " + available;
	}
}
