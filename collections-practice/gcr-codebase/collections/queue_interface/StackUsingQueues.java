package queue_interface;
import java.util.*;

class QueueStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    //push
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    //pop
    public int pop() {
        return q1.remove();
    }
    //top
    public int top() {
        return q1.peek();
    }
    //empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueues {
    public static void main(String[] args) {
    	QueueStack stack = new QueueStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop()); 
        System.out.println("Top after pop: " + stack.top());
    }
}
