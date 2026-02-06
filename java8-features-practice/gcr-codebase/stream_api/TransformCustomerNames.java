package stream_api;
import java.util.*;

// main class
public class TransformCustomerNames {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("Raven", "Andrew", "Bob", "Kolin");

		names.stream().map(n -> n.toUpperCase()) // convert to uppercase
				.sorted() // sort alphabetically
				.forEach(System.out::println);
	}
}
