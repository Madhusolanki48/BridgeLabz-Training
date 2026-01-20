package TrafficManager;
import java.util.*;

//roundabout using Circular Linked List
class Roundabout {
	private Node head = null;

	//method to add vehicle into circular list
	public void addVehicle(Vehicle v) {
		Node newNode = new Node(v);

		if (head == null) {
			head = newNode;
			head.next = head;
			return;
		}

		Node temp = head;
		while (temp.next != head)
			temp = temp.next;

		temp.next = newNode;
		newNode.next = head;
	}

	//method to remove vehicle from roundabout
	public boolean removeVehicle(String vehicleNumber) {
		if (head == null)
			return false;

		Node curr = head;
		Node prev = null;

		do {
			if (curr.vehicle.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {

				//single node
				if (curr == head && curr.next == head) {
					head = null;
					return true;
				}

				//removing head
				if (curr == head) {
					Node last = head;
					while (last.next != head)
						last = last.next;

					head = head.next;
					last.next = head;
				} else {
					prev.next = curr.next;
				}
				return true;
			}
			prev = curr;
			curr = curr.next;
		} while (curr != head);

		return false;
	}

	//method to print state
	public void displayRoundabout() {
		if (head == null) {
			System.out.println("Roundabout is empty.");
			return;
		}

		System.out.println("Vehicles in Roundabout - Circular Path:");
		Node temp = head;
		do {
			System.out.print(temp.vehicle + " -> ");
			temp = temp.next;
		} while (temp != head);
		System.out.println("(back to start)");
	}

	public boolean isEmpty() {
		return head == null;
	}
}
