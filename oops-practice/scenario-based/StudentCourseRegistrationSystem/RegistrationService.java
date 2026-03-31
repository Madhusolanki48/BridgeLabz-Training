package StudentCourseRegistrationSystem;

//abstraction
public abstract class RegistrationService {
	//abstract methods
	public abstract void enrollCourse(Student student, Course course) throws CourseLimitExceededException;
	public abstract void dropCourse(Student student, int courseId);
	public abstract void assignGrade(Student student, int courseId, String grade);
}
