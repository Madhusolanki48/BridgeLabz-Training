package TrafficManager;
import java.util.*;

//circular linked list node
class Node {
	Vehicle vehicle;
	Node next;

	Node(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.next = null;
	}
}

