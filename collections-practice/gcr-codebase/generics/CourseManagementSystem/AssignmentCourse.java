package CourseManagementSystem;

public class AssignmentCourse extends CourseType {
	//constructor
    AssignmentCourse(int courseId, String courseName, int semester, int credits,
                     String facultyName, String duration) {
        super(courseId, courseName, semester, credits, facultyName, duration, "Assignment Based");
    }
}
