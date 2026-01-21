package CourseManagementSystem;

public class ResearchCourse extends CourseType {
	//constructor
    ResearchCourse(int courseId, String courseName, int semester, int credits,
                   String facultyName, String duration) {
        super(courseId, courseName, semester, credits, facultyName, duration, "Research Based");
    }
}
