package arrays;
import java.util.Scanner;
public class GradesNPercentage2D {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    
        //number of students
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];   // marks of 3 subjects
        double[] percentage = new double[n];
        char[] grade = new char[n];

        //marks input by the user
        for (int i = 0; i < n; i++) { 
            System.out.println("Enter marks for Student " + (i + 1) +" :");
            System.out.print("Enter Physics marks: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Enter Maths marks: ");
            marks[i][2] = sc.nextInt();

            //percentage calculation
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

            //grade
            if (percentage[i] >= 90) {
                grade[i] = 'A';
            }
            else if (percentage[i] >= 75) {
                grade[i] = 'B';
            }
            else if (percentage[i] >= 60) {
                grade[i] = 'C';
            }
            else {
                grade[i] = 'D';
            }
        }
        //print result
        for (int i = 0; i < n; i++) {
        	System.out.printf("Student %d : Percentage: %.2f, Grade: %c%n",
        		    (i + 1), percentage[i], grade[i]);
        }
    }
}
