package arrays;
import java.util.Scanner;
public class MeanHeightOfPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //array of size 11 for heights of team players
        double[] heights = new double[11];
        double sum = 0;
        System.out.print("Enter the height of players (in cm) : ");
        //sum of heights
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }
        //mean = sum of all elements / number of elements
        double mean = sum / 11;
        System.out.printf("Mean height of football team = %.2f", mean);
    }	
}
