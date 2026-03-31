package StudentCourseRegistrationSystem;

//grade record class
public class GradeRecord {
	//attributes
	private int courseId;
	private String grade;
	//constructor
	public GradeRecord(int courseId, String grade) {
		this.courseId = courseId;
		this.grade = grade;
	}
	//getters
	public int getCourseId() {
		return courseId;
	}

	public String getGrade() {
		return grade;
	}
	//setter
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grade Details[ " + "Course Id - " + courseId + " | Grade - " + grade+" ]";
	}
}
