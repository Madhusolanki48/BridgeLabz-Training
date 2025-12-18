import java.util.Scanner;
public class MaxNumOfHandshakes {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the number of students : ");
	        int numberOfStudents = sc.nextInt();                // number of students
	        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;  // combination formula
	        System.out.println("The maximum number of handshakes is " + handshakes);
	    }
}
