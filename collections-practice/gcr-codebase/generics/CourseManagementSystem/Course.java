package CourseManagementSystem;
import java.util.*;

//generic course manager
public class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();
    //method to add course
    public void addCourse(T course) { 
        courseList.add(course);
    }

    List<T> getCourses() { //return all courses
        return courseList;
    }
}
