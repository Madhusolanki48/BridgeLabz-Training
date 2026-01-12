package StudentCourseRegistrationSystem;

//course class
public class Course {
	//attributes
	private int courseId;
	private String courseName;
	private int credits;
	//constructor
	public Course(int courseId, String courseName, int credits) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.credits = credits;
	}
	//getters
	public int getId() {
		return courseId;
	}

	public String getName() {
		return courseName;
	}
	public int getCredits() {
		return credits;
	}
	@Override
	public String toString() {
		return "Course Details: " + "Id - " + courseId + " | Name - " + courseName + " | Credits - " + credits;
	}
}
