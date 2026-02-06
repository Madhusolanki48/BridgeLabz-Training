package stream_api;
import java.time.*;
import java.util.*;

public class LoggingTransactions {
	public static void main(String[] args) {

		List<String> transactionIds = Arrays.asList("TID101", "TID102");

		transactionIds.forEach(id -> System.out.println(LocalDateTime.now()
				+ " - Transaction: " + id)); // log transaction
	}
}
