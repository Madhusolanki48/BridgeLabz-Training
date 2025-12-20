package arrays;
import java.util.Scanner;
public class MultiplicationTableSixToNine {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter a number : ");
		 int number = sc.nextInt();
		 int[] multiplicationResult = new int[4];
		 int index = 0;
		 // store results
		 for(int i = 6; i <= 9; i++) {
			 multiplicationResult[index] = number * i;
			 index++;
			 }
		 index = 0;
		 //print multiplication table from 6 to 9
		 for (int i = 6; i <= 9; i++) {
			 System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
			 index++;
		 }
	 }
}
	

