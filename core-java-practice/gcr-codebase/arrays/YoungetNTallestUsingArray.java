package arrays;
import java.util.Scanner;
public class YoungetNTallestUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];
        
        //take user input for age and height
        for (int i = 0; i < 3; i++) {
        	System.out.println("Enter details for " + names[i]);

            System.out.print("Age: ");
            age[i] = sc.nextInt();

            System.out.print("Height (in cm): ");
            height[i] = sc.nextDouble();
        }
        int youngest = 0;
        int tallest = 0;
        
        //Youngest and Tallest
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngest]) youngest = i;
            if (height[i] > height[tallest]) tallest = i;
        }
        //print result
        System.out.println(names[youngest]+" is the Youngest.");
        System.out.println(names[tallest]+" is the Tallest.");
    }

}
