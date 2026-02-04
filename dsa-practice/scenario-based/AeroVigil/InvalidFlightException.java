package AeroVigil;
//custom exception
public class InvalidFlightException extends Exception{
	public InvalidFlightException(String message) {
		super(message);
	}
}
