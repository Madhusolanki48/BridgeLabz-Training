package DigitalSubscriptionRenewalSystem;
import java.time.LocalDate;
import java.util.*;

public class SubscriptionSystem {

	//auto renew logic
	public static void autoRenew(User user, DiscountStrategy strategy) throws PaymentDeclinedException {

		if (!user.paymentValid) {
			throw new PaymentDeclinedException("Payment failed for " + user.name);
		}

		double fee = 100;
		double finalFee = strategy.applyDiscount(fee);

		user.expiryDate = user.expiryDate.plusMonths(1);

		System.out.println(user.name + " renewed. Paid: " + finalFee + " | New Expiry: " + user.expiryDate);
	}

	public static void main(String[] args) {

		List<User> users = List.of(new User("Maxwell", LocalDate.now().minusDays(1), true),
				new User("Raven", LocalDate.now().plusDays(5), true),
				new User("Andrew", LocalDate.now().minusDays(2), false));

		DiscountStrategy discount = new FestiveDiscount();

		System.out.println("Expired Users:");
		users.stream().filter(u -> u.expiryDate.isBefore(LocalDate.now())).forEach(u -> System.out.println(u.name));

		System.out.println("\nAuto Renewal:");

		for (User u : users) {
			try {
				autoRenew(u, discount);
			} catch (PaymentDeclinedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}