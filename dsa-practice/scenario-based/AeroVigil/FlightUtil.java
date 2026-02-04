package AeroVigil;

public class FlightUtil {
	//method to validate flight number
	public boolean validateFlightNumber(String flightNumber)
			throws InvalidFlightException {
		if (!(flightNumber.matches("FL-[0-9]{4}"))) {
			throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
		}
		return true;
	}
    //method to validate flight name
	public boolean validateFlightName(String flightName)
			throws InvalidFlightException {
		if (!(flightName.equals("SpiceJet") || flightName.equals("Vistara") || flightName.equals("IndiGo")
				|| flightName.equals("Air Arabia"))) {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		return true;
	}
    //method to validate passenger count
	public boolean validatePassengerCount(int passengerCount, String flightName)
			throws InvalidFlightException {
		if (passengerCount <= 0 || (flightName.equals("SpiceJet") && passengerCount > 396)
				|| (flightName.equals("Vistara") && passengerCount > 615)
				|| (flightName.equals("IndiGo") && passengerCount > 230)
				|| (flightName.equals("Air Arabia") && passengerCount > 130)) {
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		return true;
	}
    //method to calculate fuel to fill tank
	public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
			throws InvalidFlightException {
		if (currentFuelLevel < 0 || (flightName.equals("SpiceJet") && currentFuelLevel > 200000)
				|| (flightName.equals("Vistara") && currentFuelLevel > 300000)
				|| (flightName.equals("IndiGo") && currentFuelLevel > 250000)
				|| (flightName.equals("Air Arabia") && currentFuelLevel > 150000)) {
			throw new InvalidFlightException("Invalid fuel level for " + flightName);
		}
		if (flightName.equals("SpiceJet")) {
			return 200000 - currentFuelLevel;
		}
		if (flightName.equals("Vistara")) {
			return 300000 - currentFuelLevel;
		}
		if (flightName.equals("IndiGo")) {
			return 250000 - currentFuelLevel;
		}
		if (flightName.equals("Air Arabia")) {
			return 150000 - currentFuelLevel;
		}
		return 0;

	}

}
