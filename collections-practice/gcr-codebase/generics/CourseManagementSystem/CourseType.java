package CourseManagementSystem;

//abstract course type
public abstract class CourseType {
	//attributes
    int courseId;
    String courseName;
    int semester;
    int credits;
    String facultyName;
    String duration;
    String evaluationType;
    
    //constructor
    CourseType(int courseId, String courseName, int semester, int credits,
               String facultyName, String duration, String evaluationType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.semester = semester;
        this.credits = credits;
        this.facultyName = facultyName;
        this.duration = duration;
        this.evaluationType = evaluationType;
    }

    public void displayCourse() {
        System.out.println("Course ID        : " + courseId);
        System.out.println("Course Name      : " + courseName);
        System.out.println("Course Type      : " + getClass().getSimpleName());
        System.out.println("Semester         : " + semester);
        System.out.println("Credits          : " + credits);
        System.out.println("Faculty          : " + facultyName);
        System.out.println("Duration         : " + duration);
        System.out.println("Evaluation Type  : " + evaluationType);
        System.out.println("-------------------------------------------");
    }
}
