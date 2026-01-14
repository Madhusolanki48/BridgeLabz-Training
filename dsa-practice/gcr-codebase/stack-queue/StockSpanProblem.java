package stack_queue;
import java.util.Scanner;
import java.util.Stack;
//Stock Span Problem
public class StockSpanProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements of the array: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ans = stockSpan(arr);
		for (int i : ans) {
			System.out.println(i);
		}

	}
    //method to find stock span
	public static int[] stockSpan(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? i + 1 : (i - stack.peek());
			stack.push(i);
		}
		return ans;
	}

}