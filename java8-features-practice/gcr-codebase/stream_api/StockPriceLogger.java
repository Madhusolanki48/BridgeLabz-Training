package stream_api;

import java.util.*;

public class StockPriceLogger {
	public static void main(String[] args) {

		List<Double> prices = Arrays.asList(120.5, 121.0, 119.8, 122.3);
		
		System.out.println("Live Stock Prices:");
		prices.forEach(p -> System.out.println("Stock Price: " + p)); // print prices
	}
}
