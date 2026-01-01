package this_static_final;
//Program 5: University Student Management
public class Student {
    //static variable
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    //final variable
    private final int rollNumber;
    //instance variables
    private String name;
    private String grade;
    //constructor using 'this'
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }
    //static method
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    public void updateGrade(String grade) {
        this.grade = grade;
        System.out.println("Grade updated to: "+grade);
    }
    //display details using instanceof
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }
    //main method
    public static void main(String[] args) {
        Student student1 = new Student(101, "Hemashree", "A");
        Student student2 = new Student(102, "Sharmila", "B");
        displayTotalStudents();
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student2.updateGrade("A");
        student2.displayStudentDetails();
    }
}
