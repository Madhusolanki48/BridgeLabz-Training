package leet_code_codebase;
import java.util.Scanner;
import java.util.Stack;
// LeetCode Problem: 682
// Calculate the total score based on operations using stack.
public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] operations = new String[n];
        System.out.println("Enter operations:");
        for (int i = 0; i < n; i++) {
            operations[i] = sc.nextLine();
        }
        //method calling
        int result = calPoints(operations);
        //print output
        System.out.println("Total Score: " + result);
    }

    //method to calculate score
    static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if (op.equals("C")) {
                //remove last score
                stack.pop();
            }
            else if (op.equals("D")) {
                //double last score
                stack.push(2 * stack.peek());
            }
            else if (op.equals("+")) {
                //sum of last two scores
                int last = stack.pop();
                int secondLast = stack.peek();
                stack.push(last);
                stack.push(last + secondLast);
            }
            else {
                //normal integer score
                stack.push(Integer.parseInt(op));
            }
        }

        //sum all scores
        int total = 0;
        for (int score : stack) {
            total += score;
        }

        return total;
    }
}
