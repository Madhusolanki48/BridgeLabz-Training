package scenario_based;
import java.util.*;
public class LineComparisonProblem {
	public static void main(String[] args) {
		System.out.println("--- Welcome to Line Comparison Computation Program --- ");
		Scanner sc=new Scanner(System.in);
		
		// Use Case-1 : Calculate Length of a Line using Cartesian-System
		
		//user input for co-ordinates of points
		System.out.print("Enter the value of x1 : ");
		int x1=sc.nextInt();
		System.out.print("Enter the value of x2 : ");
		int x2=sc.nextInt();
		System.out.print("Enter the value of y1 : ");
		int y1=sc.nextInt();
		System.out.print("Enter the value of y2 : ");
		int y2=sc.nextInt();
		//calculating length using co-ordinates of two points
		double length = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		
		//print length of line
		System.out.printf("Length of the Line = %.2f unit",length);
	}

}
