package methods;
import java.util.Random;
public class HeightOfFootballPlayers {
	public static void main(String[] args) {
		//user input
        int[] heights = getRandomHeights(11);
        System.out.println("Enter the Height of Players (in cm) :");
        for (int h : heights)
        	System.out.print(h + " ");
        //print output
        System.out.println("\nShortest Height : " + getShortestHeight(heights));
        System.out.println("Tallest Height : " + getTallestHeight(heights));
        System.out.println("Mean Height : " + getMean(heights));
    }
	//method generate random heights between 150–250 cm
    public static int[] getRandomHeights(int size) {
        int[] heights = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            heights[i] = rand.nextInt(101) + 150;
        return heights;
    }
    //method to find the sum of all the elements present in the array
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int value : arr)
        	sum += value;
        return sum;
    }
    //method to find the mean height of the players on the football team
    public static double getMean(int[] arr) {
        return (double) getSum(arr) / arr.length;
    }
    //method to find the shortest height of the players on the football team 
    public static int getShortestHeight(int[] arr) {
        int min = arr[0];
        for (int value : arr)
        	if (value < min) min = value;
        return min;
    }
    //method to find the tallest height of the players on the football team
    public static int getTallestHeight(int[] arr) {
        int max = arr[0];
        for (int value : arr)
        	if (value > max) max = value;
        return max;
    }


}
