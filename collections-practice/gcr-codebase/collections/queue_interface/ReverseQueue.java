package queue_interface;
import java.util.*;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        //remove from queue and push to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());  //push operation
        }

        //pop from stack and add to queue
        while (!stack.isEmpty()) {
        	queue.add(stack.pop());     //add operation
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
