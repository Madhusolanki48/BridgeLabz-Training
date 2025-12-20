package arrays;
import java.util.Scanner;
public class BMIUsing1DArray {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //number of persons
        System.out.print("Enter number of Players : ");
        int n = sc.nextInt();
        //initializing 1-D array sizes to store person data
        double[] weight = new double[n];  
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        //taking input and calculating BMI
        
        for (int i = 0; i < n; i++) {
        	System.out.println("Enter details for Player " + (i + 1)+" :");
        	
            System.out.print("Enter the weight of the player (in kg): ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter the height of the player (in cm): ");
            height[i] = sc.nextDouble();
            //BMI Calculation 
            bmi[i] = weight[i] / (height[i] * height[i]);
            //BMI status
            if (bmi[i] < 18.5)
            	status[i] = "Underweight";
            else if (bmi[i] < 25)
            	status[i] = "Normal";
            else if (bmi[i] < 30)
            	status[i] = "Overweight";
            else
            	status[i] = "Obese";
        }

        for (int i = 0; i < n; i++)
        	System.out.printf("Player %d - Weight: %.2f, Height: %.2f, BMI: %.4f, Status: %s%n",
        		   (i+1), weight[i],height[i],bmi[i],status[i]);
	}

}
