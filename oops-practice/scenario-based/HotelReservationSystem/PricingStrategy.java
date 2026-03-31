package HotelReservationSystem;

//interface
public interface PricingStrategy {
	double calculateTotal(Room room, int nights);
}
