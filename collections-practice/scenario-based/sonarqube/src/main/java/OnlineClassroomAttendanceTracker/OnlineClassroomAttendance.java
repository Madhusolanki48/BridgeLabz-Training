package OnlineClassroomAttendanceTracker;

//main class
public class OnlineClassroomAttendance {
	public static void main(String[] args) {
		AttendanceTracker tracker = new AttendanceTracker();

		try {
			tracker.markAttendance("101", "Maxwell");
			tracker.markAttendance("101", "Andrew");
			tracker.markAttendance("102", "Samuel");

			// duplicate attendance case
			tracker.markAttendance("101", "Maxwell");

		} catch (DuplicateAttendanceException e) {
			System.out.println(e.getMessage());
		}

		tracker.removeAttendance("101", "Andrew");
		tracker.displayAttendance();
	}
}
