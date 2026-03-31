package methods;
import java.util.Scanner;
public class YoungestNTallest {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // friend names
        String[] names = {"Amar", "Akbar", "Anthony"};
        //arrays for age and height
        int[] ages = new int[3];
        double[] height = new double[3];
        //user input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + " : ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + " (in cm) : ");
            height[i] = sc.nextDouble();
        }
        //method calls
        int youngest = findYoungest(ages);
        int tallest = findTallest(height);
        //display result
        System.out.println("\nYoungest friend among them : " + names[youngest]);
        System.out.println("Tallest friend among them : " + names[tallest]);
    }
	//method to find the youngest of the 3 friends
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }
    //method to find the tallest of the 3 friends
    public static int findTallest(double[] height) {
        int tallestIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
}
