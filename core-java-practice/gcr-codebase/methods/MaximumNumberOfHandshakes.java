package methods;
import java.util.Scanner;
public class MaximumNumberOfHandshakes {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter number of students : ");
		int numberOfStudents=sc.nextInt();
		int result=maxNumberOfHandShakes(numberOfStudents);
		//display possible number of handshakes
		System.out.print("Number of possible Handshakes = "+result);
	}
	//method to find maximum number of handshakes
	public static int maxNumberOfHandShakes(int numberOfStudents) {
		//combination formula to calculate the maximum number of possible handshakes
		int possibleHandshakes= (numberOfStudents * (numberOfStudents - 1)) / 2;
		return possibleHandshakes;
	}

}
