package OnlineCourseEnrollmentManager;
import java.time.LocalDate;

//stores enrollment details
public class Enrollment {
	//attributes
    private String studentName;
    private String courseName;
    private String courseCategory;
    private LocalDate enrollmentDate;

    //constructor
    public Enrollment(String studentName, String courseName,
                      String courseCategory, LocalDate enrollmentDate) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseCategory = courseCategory;
        this.enrollmentDate = enrollmentDate;
    }

    //getter method
    public String getStudentName() { return studentName; }
    public String getCourseName() { return courseName; }
    public String getCourseCategory() { return courseCategory; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }

    @Override
    public String toString() {
        return studentName + " | " + courseName + " | " +
               courseCategory + " | " + enrollmentDate;
    }
}
