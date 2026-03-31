package CourseManagementSystem;

public class ExamCourse extends CourseType {
	//constructor
    ExamCourse(int courseId, String courseName, int semester, int credits,
               String facultyName, String duration) {
        super(courseId, courseName, semester, credits, facultyName, duration, "Exam Based");
    }
}
