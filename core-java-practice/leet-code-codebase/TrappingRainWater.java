package leet_code_codebase;
import java.util.Scanner;
//Leetcode Problem No.-42
//Given heights of bars in an elevation map, calculate how much rainwater can be trapped between them.
public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of elements: ");
        int number = sc.nextInt();
        int[] height = new int[number];
        System.out.print("Enter bar heights:");
        for (int i = 0; i < number; i++) {
            height[i] = sc.nextInt();
        }
        //method call
        int result = trapWater(height);
        //print output
        System.out.println("Total trapped water: " + result);

    }
    //method to trap water
    public static int trapWater(int[] height) {
        //if array size is too small, no water can be trapped
    	if (height.length <= 2)
            return 0;
        int n = height.length;
        //two pointers
        int left = 1;
        int right = n - 2;
        //store maximum heights seen from both sides
        int maxLeft = height[0];
        int maxRight = height[n - 1];

        int water = 0;   //answer

        while (left <= right) {
            //left side is smaller,process left side
            if (maxLeft < maxRight) {

                //update maxLeft if a taller bar is found
                if (height[left] > maxLeft)
                    maxLeft = height[left];
                else
                    //water trapped = boundary − bar height
                    water += maxLeft - height[left];
                left++;
            }
            //right side is smaller or equal, process right side
            else {

                if (height[right] > maxRight)
                    maxRight = height[right];
                else
                    water += maxRight - height[right];

                right--;
            }
        }
        return water;
    }
}
