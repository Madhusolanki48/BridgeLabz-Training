package stack_queue;
import java.util.*;
//Sliding Window Maximum
public class SlidingWindowMaximum {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");  
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();
        //validation
        if (k > n || k <= 0) {
            System.out.println("Invalid k! k must be between 1 and n.");
            return;
        }

        int[] result = maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Maximum:");
        for (int x : result) {
            System.out.print(x + " ");
        }

    }
	//method to find maximum sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        for (int i = 0; i < n; i++) {
            //remove indices out of window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            //remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            //record answer when window completes
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
    
}
