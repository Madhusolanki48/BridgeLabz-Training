package leet_code_codebase;
import java.util.*;
//Assign ranks to athletes based on scores.Top 3 get medals, others get their rank numbers.

public class RelativeRanks {

    //find maximum value in array
    static int findMax(int[] score) {
        int max = Integer.MIN_VALUE;
        for (int x : score)
            max = Math.max(max, x);
        return max;
    }
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int maxVal = findMax(score);
        //frequency array storing original index (index+1 to avoid default 0)
        int[] freq = new int[maxVal + 1];
        for (int i = 0; i < n; i++) {
            freq[score[i]] = i + 1;
        }
        String[] result = new String[n];
        int rank = 1;
        //traverse scores from high → low
        for (int i = maxVal; i >= 0; i--) {

            if (freq[i] != 0) {
                int originalIndex = freq[i] - 1;
                if (rank == 1)
                    result[originalIndex] = "Gold Medal";
                else if (rank == 2)
                    result[originalIndex] = "Silver Medal";
                else if (rank == 3)
                    result[originalIndex] = "Bronze Medal";
                else
                    result[originalIndex] = Integer.toString(rank);

                rank++;

                if (rank > n)
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of Athletes: ");
        int n = sc.nextInt();
        int[] score = new int[n];
        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        //method calling
        String[] ranks = findRelativeRanks(score);
        System.out.println("Relative Ranks:");
        for (String r : ranks)
            System.out.println(r);
    }
}
