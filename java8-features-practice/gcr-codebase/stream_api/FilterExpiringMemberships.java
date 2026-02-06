package stream_api;
import java.time.*;
import java.util.*;

// stores member details
class Member {
	String name;
	LocalDate expiryDate;

	// constructor
	Member(String name, LocalDate expiryDate) {
		this.name = name;
		this.expiryDate = expiryDate;
	}
}

// main class
public class FilterExpiringMemberships {
	public static void main(String[] args) {

		List<Member> members = Arrays.asList(new Member("Andrew", LocalDate.now().plusDays(10)),
				new Member("Raven", LocalDate.now().plusDays(45)),
				new Member("Katty", LocalDate.now().plusDays(25)),
				new Member("Nejin", LocalDate.now().plusDays(5)));

		members.stream().filter(
				m -> m.expiryDate.isAfter(LocalDate.now())
				&& m.expiryDate.isBefore(LocalDate.now().plusDays(31))) // next 30 days																								// days
				.forEach(m -> System.out.println(m.name + " " + m.expiryDate));
	}
}
