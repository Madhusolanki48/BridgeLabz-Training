package leet_code_codebase;
import java.util.*;
//Leetcode Problem - 888
//Alice and Bob have candy boxes of different sizes.Find one candy size from Alice and one from Bob such that after swapping, both have equal total candies.

public class FairCandySwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of boxes Alice has: ");
        int m = sc.nextInt();
        int[] alice = new int[m];
        System.out.println("Enter Alice's candy sizes:");
        for (int i = 0; i < m; i++) {
            alice[i] = sc.nextInt();
        }
        System.out.print("Enter number of boxes Bob has: ");
        int n = sc.nextInt();
        int[] bob = new int[n];

        System.out.print("Enter Bob's candy sizes:");
        for (int i = 0; i < n; i++) {
            bob[i] = sc.nextInt();
        }
        //method call
        int[] result = fairCandySwap(alice, bob);

        if (result.length == 0)
            System.out.println("No valid swap found");
        else
            System.out.println("Swap -> Alice: " + result[0] +", Bob: " + result[1]);

    }

    //method to find swap values
    public static int[] fairCandySwap(int[] alice, int[] bob) {

        int aliceTotal = 0;
        int bobTotal = 0;

        //total candies for Alice & Bob
        for (int x : alice) aliceTotal += x;
        for (int x : bob) bobTotal += x;

        //sort Bob's array to enable binary search
        Arrays.sort(bob);

        //try each candy from Alice
        for (int x : alice) {

            //derived target candy value from Bob
            int target = (bobTotal + 2 * x - aliceTotal) / 2;

            //if Bob has that candy, valid swap found
            if (binarySearch(bob, target))
                return new int[] { x, target };
        }

        return new int[0];
    }

    //binary search helper
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < arr[mid])
                right = mid - 1;
            else if (target > arr[mid])
                left = mid + 1;
            else
                return true;
        }

        return false;
    }
}
