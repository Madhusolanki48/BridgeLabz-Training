package class_and_object;

// Class to store student marks and calculate grade
class Student {
    //attributes
    private String name, rollNumber;
    private double marks1, marks2, marks3;
    //constructor
    public Student(String name, String rollNumber, double m1, double m2, double m3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks1 = m1;   
        this.marks2 = m2;   
        this.marks3 = m3;   
    }
    //method to calculate the grade based on the marks
    public char getGrade() {
        double averageMarks = (marks1 + marks2 + marks3) / 3; //to calculate avg marks
        if (averageMarks >= 80) return 'A';
        else if (averageMarks >= 70) return 'B';
        else if (averageMarks >= 60) return 'C';
        return 'D';
    }

    //method to display the student's details and grade
    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + marks1);
        System.out.println("Mark2: " + marks2);
        System.out.println("Mark3: " + marks3);
        System.out.println("Grade: " + getGrade()); 
        System.out.println();
    }
}

public class StudentDetailsAndGrades {
    public static void main(String[] args) {
        Student student1 = new Student("Thamarai", "ECE001", 80, 70, 75);
        Student student2 = new Student("Kannan", "CSC002", 60, 65, 50);
        student1.display();
        student2.display();
    }
}
