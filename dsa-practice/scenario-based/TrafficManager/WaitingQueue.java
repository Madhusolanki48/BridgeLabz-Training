package TrafficManager;
import java.util.*;

//waiting Queue
class WaitingQueue {
	private Queue<Vehicle> queue = new LinkedList<>();
	private int capacity;  //attritbute
   //constructor
	WaitingQueue(int capacity) {
		this.capacity = capacity;
	}
    //queue operations
	public void enqueue(Vehicle v) {
		if (queue.size() == capacity) {
			System.out.println("Queue Overflow! Waiting area is full.");
			return;
		}
		queue.add(v);
		System.out.println("Vehicle added to waiting queue!");
	}

	public Vehicle dequeue() {
		if (queue.isEmpty()) {
			System.out.println("Queue Underflow! No vehicles waiting.");
			return null;
		}
		return queue.poll();
	}
    //method to display queue
	public void displayQueue() {
		if (queue.isEmpty()) {
			System.out.println("Waiting Queue is empty!");
			return;
		}
		System.out.println("Vehicles Waiting: " + queue);
	}
}
