package CourseManagementSystem;
import java.util.*;

public class UniversityCourseSystem {

    //wildcard: display any course list
    public static void displayAll(String deptName, List<? extends CourseType> list) {
        System.out.println("\n----------- " + deptName.toUpperCase() + " DEPARTMENT COURSES ----------");
        for (CourseType c : list)
        	c.displayCourse();
    }

    public static void main(String[] args) {
        System.out.println("-----  Welcome to University Course System  -----");

        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse(101, "Computer Networks", 5, 4, "Dr. Maxwell", "16 Weeks"));
        examDept.addCourse(new ExamCourse(102, "Operating System", 4, 4, "Prof. David", "16 Weeks"));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse(201, "AI Thesis", 7, 6, "Dr. Maxican", "24 Weeks"));
        researchDept.addCourse(new ResearchCourse(202, "Blockchain Research", 8, 6, "Dr. Gablin", "24 Weeks"));

        Course<AssignmentCourse> assignmentDept = new Course<>();
        assignmentDept.addCourse(new AssignmentCourse(301, "Java Assignments", 3, 2, "Ms. Ramen", "8 Weeks"));
        assignmentDept.addCourse(new AssignmentCourse(302, "DBMS Assignments", 3, 2, "Mr. Andrew", "8 Weeks"));
        //method calling
        displayAll("Exam", examDept.getCourses());
        displayAll("Research", researchDept.getCourses());
        displayAll("Assignment", assignmentDept.getCourses());

        System.out.println("\nAll courses displayed successfully!");
    }
}
