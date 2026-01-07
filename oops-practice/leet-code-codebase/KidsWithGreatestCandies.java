package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1431
// For each kid, check whether adding extraCandies makes their candies
// greater than or equal to the maximum candies among all kids.

public class KidsWithGreatestCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of kids: ");
        int n = sc.nextInt();

        int[] candies = new int[n];
        System.out.println("Enter candies for each kid:");
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        System.out.print("Enter extra candies: ");
        int extraCandies = sc.nextInt();

        //method calling
        List<Boolean> result = kidsWithCandies(candies, extraCandies);

        //print output
        System.out.println("Result (true = can become greatest):");
        System.out.println(result);
    }

    // method to check which kids can have max candies
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();

        //find maximum candies
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max)
                max = candy;
        }
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}
