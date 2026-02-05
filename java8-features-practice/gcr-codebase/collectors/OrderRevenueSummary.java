package collectors;
import java.util.*;
import java.util.stream.*;

class Order {
	String customer;
	double amount;
    //constructor
	Order(String customer, double amount) {
		this.customer = customer;
		this.amount = amount;
	}
    //getter method
	String getCustomer() {
		return customer;
	}

	double getAmount() {
		return amount;
	}
}

public class OrderRevenueSummary {
	public static void main(String[] args) {

		List<Order> orders = List.of(new Order("Amiley", 500), new Order("Raven", 300), new Order("Andrew", 200));

		//sum order amount per customer
		Map<String, Double> revenue = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getAmount)));

		System.out.println(revenue);
	}
}
