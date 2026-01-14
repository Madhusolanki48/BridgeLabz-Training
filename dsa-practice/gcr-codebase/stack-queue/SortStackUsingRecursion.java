package stack_queue;
import java.util.*;
//Sort a Stack Using Recursion
public class SortStackUsingRecursion {
    //insert element at correct position in sorted stack
    public static void insertSorted(Stack<Integer> stack, int a) {
        if (stack.isEmpty() || stack.peek() <= a) {
            stack.push(a);
            return;
        }
        int top = stack.pop();
        insertSorted(stack, a);
        stack.push(top);
    }

    //sort stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }

    public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(5);
		stack.push(3);
		stack.push(2);
		System.out.println("Original stack : " + stack);
		sortStack(stack);
		System.out.println("Sorted stack : " + stack);
	}
}
