package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 771
// Count how many characters in 'stones' are also present in 'jewels'.

public class JewelsAndStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter jewels string: ");
        String jewels = sc.nextLine();
        System.out.print("Enter stones string: ");
        String stones = sc.nextLine();

        //method calling
        int result = countJewels(jewels, stones);
        // print output
        System.out.println("Number of jewels in stones: " + result);
    }

    //method to count matching characters
    static int countJewels(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {

                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
