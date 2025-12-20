package control_flows;
import java.util.Scanner;
public class BMICalculator {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input user details
        System.out.print("Enter the weight of a person (in kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter the height of a person (in cm): ");
        double heightCm = sc.nextDouble();
        //Height conversion from cm to meters
        double heightM = heightCm / 100;
        //BMI calculation
        double bmi = weight / (heightM * heightM);
        System.out.printf("BMI calculated = %.2f ",bmi);
        System.out.println();

        //Weight status determination
        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }
    }
}
