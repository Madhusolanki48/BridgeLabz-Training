package hashmaps;
import java.util.*;

public class TwoSumProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int[] ans = twoSum(arr, target);

        if (ans[0] == -1) System.out.println("No pair found!");
        else System.out.println("Indices: " + ans[0] + ", " + ans[1]);

    }

    public static int[] twoSum(int[] arr, int target) {
        // value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            // pair found
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }

            // store current value
            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
}
