package scenario_based;
import java.util.*;
public class LineComparisonProblem {
	public static void main(String[] args) {
		System.out.println("--- Welcome to Line Comparison Computation Program --- ");
		Scanner sc=new Scanner(System.in);
		
		// Use Case-1 : Calculate Length of a Line using Cartesian-System
		// for first line 
		//user input for co-ordinates of points
		System.out.println("--- Enter the Co-ordinates of First Line ---");
		System.out.print("Enter the value of x1 : ");
		int x1=sc.nextInt();
		System.out.print("Enter the value of x2 : ");
		int x2=sc.nextInt();
		System.out.print("Enter the value of y1 : ");
		int y1=sc.nextInt();
		System.out.print("Enter the value of y2 : ");
		int y2=sc.nextInt();
		//calculating length using co-ordinates of two points
		Double length = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		
		//print length of line
		System.out.printf("Length of the First Line = %.2f unit",length);
		
		// Use Case-2 : Check equality of two lines based on the end points
		
		// for second line 
		//user input for co-ordinates of points
		System.out.println("\n--- Enter the Co-ordinates of second line ---");
		System.out.print("Enter the value of x3 : ");
		int x3=sc.nextInt();
		System.out.print("Enter the value of x4 : ");
		int x4=sc.nextInt();
		System.out.print("Enter the value of y3 : ");
		int y3=sc.nextInt();
		System.out.print("Enter the value of y4 : ");
		int y4=sc.nextInt();
		
		//calculating length using co-ordinates of two points
		Double length2 = Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
		//print length of second
		System.out.printf("Length of the Second Line = %.2f unit",length2);
		
		//check equality using equals()
        if (length.equals(length2)) {
            System.out.println("\nBoth lines are Equal in length !");
        } else {
            System.out.println("\nBoth lines are not Equal in length !");
        }
    }
}
