import java.util.Scanner;
public class SideOfSquare {   //using perimeter
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the perimeter of square : ");
        double perimeter = sc.nextDouble(); // perimeter
        double side = perimeter / 4;        // side calculation
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
	}

}
