package OnlineClassroomAttendanceTracker;
import java.util.*;

//handles session-wise attendance tracking
public class AttendanceTracker {

	// Map to store attendance per session
	private Map<String, Set<String>> attendanceMap = new HashMap<>();

	//method to mark attendance for a student
	public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {

		//create session if not present
		attendanceMap.putIfAbsent(sessionId, new HashSet<>());

		// Check duplicate attendance
		if (!attendanceMap.get(sessionId).add(studentId)) {
			throw new DuplicateAttendanceException("Attendance already marked for Student: " + studentId);
		}
	}

	// method to remove student attendance
	public void removeAttendance(String sessionId, String studentId) {
		if (attendanceMap.containsKey(sessionId)) {
			attendanceMap.get(sessionId).remove(studentId);
		}
	}

	// method to display attendance for all sessions
	public void displayAttendance() {
		for (String sessionId : attendanceMap.keySet()) {
			System.out.println("Session " + sessionId + " -> " + attendanceMap.get(sessionId));
		}
	}
}
