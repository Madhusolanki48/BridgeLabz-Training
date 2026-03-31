package StudentCourseRegistrationSystem;

public class CourseRegistrationService extends RegistrationService {
	//method to enroll course
	public void enrollCourse(Student student, Course course) throws CourseLimitExceededException {

		//max 5 course limit
		if (student.getEnrolledCourses().size() >= 5) {
			throw new CourseLimitExceededException("You cannot enroll in more than 5 courses!");
		}
		//checking already enrolled or not
		for (Course c : student.getEnrolledCourses()) {
			if (c.getId() == course.getId()) {
				System.out.println("Already Enrolled in this course!");
				return;
			}
		}

		student.addCourse(course);
	}
	//method to drop course
	public void dropCourse(Student student, int courseId) {
		student.removeCourse(courseId);
	}
	//method to assign grade
	public void assignGrade(Student student, int courseId, String grade) {
		student.addOrUpdateGrade(courseId, grade);
	}
}
