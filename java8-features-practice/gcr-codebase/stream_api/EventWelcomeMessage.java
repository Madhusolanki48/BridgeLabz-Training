package stream_api;

import java.util.*;

public class EventWelcomeMessage {
	public static void main(String[] args) {

		List<String> attendees = Arrays.asList("Andrew", "Raven", "Kelvin");
		// welcome message
		attendees.forEach(name -> System.out.println("Welcome to the event, " + name + "!")); 
	}
}
