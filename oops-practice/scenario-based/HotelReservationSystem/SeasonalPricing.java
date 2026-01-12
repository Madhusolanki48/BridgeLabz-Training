package HotelReservationSystem;

//seasonal pricing -polymorphism
public class SeasonalPricing implements PricingStrategy {

	public double calculateTotal(Room room, int nights) {
		double amount = room.getBasePrice() * nights;

		//seasonal charges
		double seasonalExtra = amount * 0.10; //10% extra
		return amount + seasonalExtra;
	}
}
