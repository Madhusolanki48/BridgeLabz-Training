package HotelReservationSystem;

//deluxe room class
public class DeluxeRoom extends Room {

	//constructor
	public DeluxeRoom(int roomNumber, double basePrice) {
		super(roomNumber, basePrice);
	}

	@Override
	public String getRoomType() {
		return "Deluxe Room";
	}
}
