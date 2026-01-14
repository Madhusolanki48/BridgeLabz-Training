package stack_queue;
import java.util.*;
//Implement a Queue Using Stacks
public class QueueUsingStack {
	//empty stacks
	Stack<Integer> inStack=new Stack<>();
	Stack<Integer> outStack=new Stack<>();
	//enqueue
	public void enqueue(int a) {
		inStack.push(a);
	}
	//dequeue
	public int dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}
	//isEmpty
	public boolean isEmpty() {
		if(inStack.isEmpty() && outStack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
	    QueueUsingStack queue = new QueueUsingStack();
	    queue.enqueue(4);
	    queue.enqueue(5);
	    System.out.println(queue.dequeue()); // 4
	    queue.enqueue(6);
	    System.out.println(queue.dequeue()); // 5
	    System.out.println(queue.dequeue()); // 6
	    if(!queue.isEmpty()){
	        System.out.println(queue.dequeue());
	    } else {
	        System.out.println("Queue is empty now!");
	    }
	}
}