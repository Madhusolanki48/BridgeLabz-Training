package CourierStaffShiftScheduler;

//custom exception
public class ShiftAlreadyAssignedException extends Exception {

    public ShiftAlreadyAssignedException(String message) {
        super(message);
    }
}
