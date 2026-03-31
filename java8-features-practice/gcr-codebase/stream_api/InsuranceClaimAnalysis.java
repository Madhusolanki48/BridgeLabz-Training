package stream_api;
import java.util.*;
import java.util.stream.*;

//stores claim details
class InsuranceClaim {
	String type;
	double amount;

	// constructor
	InsuranceClaim(String type, double amount) {
		this.type = type;
		this.amount = amount;
	}
}

//main class
public class InsuranceClaimAnalysis {
	public static void main(String[] args) {

		List<InsuranceClaim> claims = Arrays.asList(new InsuranceClaim("Health", 50000),
				new InsuranceClaim("Vehicle", 30000), new InsuranceClaim("Health", 70000),
				new InsuranceClaim("Life", 100000), new InsuranceClaim("Vehicle", 40000));

		claims.stream().collect(Collectors.groupingBy(c -> c.type, // group by claim type
				Collectors.averagingDouble(c -> c.amount) // average amount
		)).forEach((type, avg) -> System.out.println(type + " : " + avg));
	}
}
