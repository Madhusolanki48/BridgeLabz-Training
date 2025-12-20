package arrays;
import java.util.Scanner;
public class GradesNPercentage1D {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        //arrays to store percentage and grade
        double[] percentage = new double[n];
        char[] grade = new char[n];
        //taking marks input and calculate percentage & grade
        for (int i = 0; i < n; i++) {
        	System.out.println("Enter marks for Student " + (i + 1)+" :");
            System.out.print("Enter Physics marks: ");
            int physics = sc.nextInt();
            System.out.print("Enter Chemistry marks: ");
            int chemistry = sc.nextInt();
            System.out.print("Enter Maths marks: ");
            int maths = sc.nextInt();
            //marks can't be negative
            if (physics < 0 || chemistry < 0 || maths < 0) {
                i--;
                continue;
            }
            //percentage calculation
            percentage[i] = (physics + chemistry + maths) / 3;
            //grade
            if (percentage[i] >= 90)
            	grade[i] = 'A';
            else if (percentage[i] >= 75)
            	grade[i] = 'B';
            else if (percentage[i] >= 60)
            	grade[i] = 'C';
            else
            	grade[i] = 'D';
        }
        //print result
        for (int i = 0; i < n; i++) {
        	System.out.printf("Student %d : Percentage: %.2f, Grade: %c%n",
        		    (i + 1), percentage[i], grade[i]);
        }
	}
}
