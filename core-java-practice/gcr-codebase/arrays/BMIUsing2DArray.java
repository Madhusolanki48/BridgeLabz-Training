package arrays;
import java.util.Scanner;
public class BMIUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //number of persons
        System.out.print("Enter number of persons : ");
        int n = sc.nextInt();
        
        //2-D array to store person data i.e. weight, height and BMI
        double[][] personData = new double[n][3];

        //An array to store BMI status
        String[] status = new String[n];

        // taking input and calculating BMI
        for (int i = 0; i < n; i++) {
        	System.out.println("Enter details for Player " + (i + 1)+" :");

        	System.out.print("Enter the weight of the player (in kg): ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter the height of the player (in cm): ");
            personData[i][1] = sc.nextDouble();
            //BMI calculation formula
            personData[i][2] =
                    personData[i][0] / (personData[i][1] * personData[i][1]);

            //BMI status
            if (personData[i][2] < 18.5)
            	status[i] = "Underweight";
            else if (personData[i][2] < 25)
            	status[i] = "Normal";
            else if (personData[i][2] < 30)
            	status[i] = "Overweight";
            else
            	status[i] = "Obese";
        }

        //height, weight, BMI and status
        for (int i = 0; i < n; i++) {
        	System.out.printf("Player %d - Weight: %.2f, Height: %.2f, BMI: %.4f, Status: %s%n",
        		    (i+1),personData[i][0],personData[i][1],personData[i][2],status[i]);
        }
    }
}
   
