package SmartParkingSystem;
//custom exception
public class NoParkingSlotAvailableException extends Exception {
    public NoParkingSlotAvailableException(String msg) {
        super(msg);
    }
}
