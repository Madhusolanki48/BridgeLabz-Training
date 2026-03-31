package OnlineClassroomAttendanceTracker;

//custom exception for duplicate attendance
public class DuplicateAttendanceException extends Exception {

	public DuplicateAttendanceException(String message) {
		super(message);
	}
}
