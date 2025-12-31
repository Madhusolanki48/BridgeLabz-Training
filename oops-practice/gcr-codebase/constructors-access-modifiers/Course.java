package constructors_access_modifiers;
//Instance vs. Class Variables and Methods
//Problem 2: Online Course Management
public class Course {
    private String courseName;   // instance variable
    private int duration;        // instance variable
    private double fee;          // instance variable
    private static String instituteName = "Delhi Technical University"; // class variable
    //parameterized constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    //instance method
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " years");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
        System.out.println("--------------------------------------------");
    }

    //class method
    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course course1 = new Course("B-tech", 4, 175000);
        Course course2 = new Course("BBA", 3, 56000);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        Course.updateInstituteName("Vellore Institute of Technology");
        course1.displayCourseDetails();
    }
}
