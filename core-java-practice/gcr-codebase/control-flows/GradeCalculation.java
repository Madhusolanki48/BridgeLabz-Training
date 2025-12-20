package control_flows;
import java.util.Scanner;
public class GradeCalculation {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input marks of a student
        System.out.print("Enter marks of Physics : ");
        int physics = sc.nextInt();
        System.out.print("Enter marks of Chemistry : ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks of Maths : ");
        int maths = sc.nextInt();
        //Percentage calculation
        double average = (physics + chemistry + maths) / 3;
        String grade;
        String remarks;
        // Grade calculation
        if (average >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Level 3, agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Level 2, below, but approaching agency normalized-standards";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency normalized-standards";
        } else if (average >= 40) {
            grade = "E";
            remarks = "Level 1, too below standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }
        // Output
        System.out.println("\nAverage Percentage: " + average + "%");
        System.out.println("Grade : " + grade);
        System.out.println("Remarks : " + remarks);
    }

}
