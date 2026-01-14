package hashmaps;
import java.util.*;

public class AllSubarraysWithZeroSum {
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
        //method calling
        zeroSumSubarrays(arr);
    }
    public static void zeroSumSubarrays(int[] arr) {
        //sum: list of indices where this sum occurred
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int sum = 0;
        boolean found = false;
        //handle subarray starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //if sum repeated, elements between indices sum to 0
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                    found = true;
                }
            }

            //store current sum index
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        if (!found) {
            System.out.println("No zero sum subarray found!");
        }
    }
}
