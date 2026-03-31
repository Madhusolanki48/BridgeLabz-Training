package CabBookingManagementSystem;
//custom exception thrown when no driver available
public class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

