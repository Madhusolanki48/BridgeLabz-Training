package hashmaps;
import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //print output
        System.out.println(longestConsecutive(arr));

    }

    public static int longestConsecutive(int[] arr) {
        //store all elements
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        int longest = 0;
        for (int x : set) {
            //start of sequence
            if (!set.contains(x - 1)) {
                int curr = x;
                int streak = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
}
