package methods;
import java.util.Scanner;
public class NumberOfRounds {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter side 1 of triangle : ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2 of triangle : ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 of triangle : ");
        double side3 = sc.nextDouble();
        //method call
        double rounds = calculateNumberOfRounds(side1, side2, side3);
        //print output
        System.out.printf("Number of rounds required: %.1f", rounds);
    }
	public static double calculateNumberOfRounds(double side1, double side2, double side3) {
		//perimter of triangle formula
        double perimeter = side1 + side2 + side3;
        double totalDistanceInMeter = 5000;   //given distance (in km)
        return totalDistanceInMeter / perimeter;
    }

}
