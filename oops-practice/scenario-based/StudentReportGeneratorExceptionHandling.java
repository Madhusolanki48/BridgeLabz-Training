package scenario_based;
import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String msg) { super(msg); }
}

class Student {
	//attributes
    String name;
    String[] subjects;
    int[] marks;
    //constructor
    Student(String name, String[] subjects, int[] marks) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }
}

public class StudentReportGeneratorExceptionHandling {

    public static void validateMarks(int[] marks) throws InvalidMarkException {
        for (int mark : marks)
        	//validate marks (should be 0–100)
            if (mark < 0 || mark > 100)
                throw new InvalidMarkException("Invalid mark: " + mark);
    }

    //method to get average marks
    public static double getAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks)
        	sum += mark;
        return sum / (double) marks.length;
    }

    public static String grade(double averageMarks) {
    	if (averageMarks >= 90)
    		return "A";
    	if (averageMarks >= 80)
    		return "B";
    	if (averageMarks >= 60)
    		return "C";
    	if (averageMarks >= 40)
    		return "D";
    	else
    		return "Fail";
    }

    public static void displayReport(Student s) {
        System.out.println("\n------- Report Card: " + s.name + " -------");
        for (int i = 0; i < s.subjects.length; i++)
            System.out.println(s.subjects[i] + " : " + s.marks[i]);

        double averageMarks = getAverage(s.marks);
        System.out.println("Average Marks : " + averageMarks);
        System.out.println("Grade         : " + grade(averageMarks));
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
       
        String[] subjects = {"Math","Science","English","Hindi"};

        System.out.println("--------  Student Report Generator  --------");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt(); sc.nextLine();
        
        for (int i = 0; i < n; i++) {

            System.out.println("\nEntering details for Student " + (i+1));
            System.out.println("----------------------------------------");

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            //array to store marks
            int[] marks = new int[subjects.length];

            for (int j = 0; j < subjects.length; j++) {
                System.out.print(subjects[j] + " marks: ");
                marks[j] = sc.nextInt();
            }
            sc.nextLine();

            try {
                validateMarks(marks);
                students.add(new Student(name, subjects, marks));
                System.out.println("Student record saved successfully!");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
                System.out.println("Re-enter details for this student.");
                i--; 
            }
        }

        System.out.println("\n---------- FINAL REPORT CARDS ----------");
        students.forEach(StudentReportGeneratorExceptionHandling::displayReport);
        System.out.println("\nReport generated successfully. Thank you!");
    }
}
