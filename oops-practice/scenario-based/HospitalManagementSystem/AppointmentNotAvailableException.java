package HospitalManagementSystem;

//custom exception
public class AppointmentNotAvailableException extends Exception {
	public AppointmentNotAvailableException(String message) {
		super(message);
	}
}
