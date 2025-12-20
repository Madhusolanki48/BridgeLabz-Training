package scenario_based;
import java.util.Scanner;
public class MayaBMIFitnessTracker {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input user details
        System.out.print("Enter the weight of a person (in kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter the height of a person (in cm): ");
        double heightCm = sc.nextDouble();
        //Height conversion from cm to meters
        double heightM = heightCm / 100;
        //BMI calculation using formula
        double bmi = weight / (heightM * heightM);
        System.out.printf("BMI calculated = %.2f ",bmi);
        System.out.println();

        //Determining Weight status of the person
        if (bmi <= 18.4) {
            System.out.println("The person is Underweight !");
        } else if (bmi <= 24.9) {
            System.out.println("The person is Normal !");
        } else {
            System.out.println("The person is Overweight !");
        } 
    }

}
