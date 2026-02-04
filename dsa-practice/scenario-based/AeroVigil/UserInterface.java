package AeroVigil;
import java.util.*;
public class UserInterface {
	public static void main(String[] args) {
		System.out.println("--------Welcome to Aero Vigil------------");
		System.out.println("-----------------------------------------");
		Scanner sc=new Scanner(System.in);
		FlightUtil flight = new FlightUtil();
		System.out.println("\nEnter flight details: ");
		//input examples
		//FL-1234:SpiceJet:250:50000
		//FL-100:Vistara:200:100000
		//FL-5678:Air Asia:120:60000
		String input=sc.nextLine();
		try {
			String[] details=input.split(":");
			String flightNumber=details[0];
			String flightName=details[1];
			int passengerCount=Integer.parseInt(details[2]);
			int currentFuelLevel=Integer.parseInt(details[3]);
			flight.validateFlightNumber(flightNumber);
			flight.validateFlightName(flightName);
			flight.validatePassengerCount(passengerCount,flightName);
			double fuelRequired=flight.calculateFuelToFillTank(flightName,currentFuelLevel);
			System.out.println("Fuel required to fill tank: "+fuelRequired+" liters");
		}
		catch(InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
	}
}
