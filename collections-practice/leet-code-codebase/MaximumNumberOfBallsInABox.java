package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1742
// Find the box with maximum balls based on digit sum.

public class MaximumNumberOfBallsInABox {
    public static void main(String[] args) {
        int lowLimit = 1;
        int highLimit = 10;
        // method calling
        int result = countBalls(lowLimit, highLimit);
        // print output
        System.out.println("Maximum balls in a box: " + result);
    }

    //method to count maximum balls in a box
    public static int countBalls(int lowLimit, int highLimit) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = lowLimit; i <= highLimit; i++) {
            int d = digitSum(i);
            map.put(d, map.getOrDefault(d, 0) + 1);
            res = Math.max(res, map.get(d));
        }

        return res;
    }

    // method to calculate digit sum
    static int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
