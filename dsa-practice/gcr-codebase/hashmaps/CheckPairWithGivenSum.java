package hashmaps;
import java.util.*;

public class CheckPairWithGivenSum {
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
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println(hasPair(arr, target));
        sc.close();
    }

    public static boolean hasPair(int[] arr, int target) {
        //store visited numbers
        HashSet<Integer> set = new HashSet<>();

        for (int x : arr) {
            //check if pair exists
            if (set.contains(target - x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}
