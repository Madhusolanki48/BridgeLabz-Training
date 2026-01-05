package leet_code_codebase;
import java.util.*;
//Leetcode Problem : 525
//Given different candy types, a girl can only eat n/2 candies.Return the maximum number of different candy types she can eat.

public class DistributeCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of candies: ");
        int n = sc.nextInt();
        int[] candyType = new int[n];
        System.out.println("Enter candy types:");
        for (int i = 0; i < n; i++) {
            candyType[i] = sc.nextInt();
        }
        //method calling
        int result = distributeCandies(candyType);
        System.out.println("Maximum different candy types she can eat: " + result);
    }

    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;
        //sort candy types
        Arrays.sort(candyType);
        //count unique candy varieties
        int unique = 1;
        for (int i = 1; i < n; i++) {
            if (candyType[i] != candyType[i - 1])
                unique++;
        }
        //n/2 candies
        return Math.min(unique, n / 2);
    }
}

