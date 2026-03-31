package linkedlist;
// Using Circular Linked List

class Process {
	//attributes
	int processId;
	int burstTime;
	int priority;

	//constructor
	Process(int processId, int burstTime, int priority) {
		this.processId = processId;
		this.burstTime = burstTime;
		this.priority = priority;
	}
}
class Node {
	Process data;
	Node next;
	Node(Process data) {
		this.data = data;
		this.next = null;
	}
}

public class RoundRobinSchedulingAlgorithm {
	//head pointer
	static Node head = null;

	//add a process at the end of the circular list
	static void insertProcess(Process process) {
		Node newNode = new Node(process);
		if (head == null) {
			head = newNode;
			newNode.next = head;
			return;
		}
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = head;
	}

	//remove a process by process ID
	static void deleteProcess(int processId) {
		if (head == null) {
			System.out.println("No processes available");
			return;
		}
		Node curr = head;
		Node prev = null;

		do {
			if (curr.data.processId == processId) {
				//if only one process exists
				if (curr == head && curr.next == head) {
					head = null;
					return;
				}
				//if head process is removed
				if (curr == head) {
					Node last = head;
					while (last.next != head) {
						last = last.next;
					}
					head = head.next;
					last.next = head;
				} else {
					prev.next = curr.next;
				}

				System.out.println("Process removed successfully");
				return;
			}

			prev = curr;
			curr = curr.next;
		} while (curr != head);
		System.out.println("Process not found");
	}

	//simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
	static void roundRobin(int timeQuantum) {
		if (head == null) {
			System.out.println("No processes to schedule");
			return;
		}

		int totalWaitingTime = 0;
		int totalTurnAroundTime = 0;
		int processCount = 0;
		Node temp = head;

		do {
			processCount++;
			temp = temp.next;
		} while (temp != head);
		System.out.println("----- Round Robin Scheduling -----");
		while (head != null) {
			Node current = head;

			do {
				if (current.data.burstTime > 0) {
					if (current.data.burstTime > timeQuantum) {
						System.out.println("Process " + current.data.processId + " executed for " + timeQuantum + " units");
						current.data.burstTime -= timeQuantum;
						totalWaitingTime += timeQuantum;
					} else {
						System.out.println("Process " + current.data.processId + " executed for "+ current.data.burstTime + " units (Completed)");
						totalTurnAroundTime += totalWaitingTime + current.data.burstTime;
						current.data.burstTime = 0;
						deleteProcess(current.data.processId);
						break;
					}
				}
				current = current.next;
			} while (current != head);
		}

		System.out.println("Average Waiting Time: " + (totalWaitingTime / processCount));
		System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / processCount));
	}

	//display all processes
	static void displayProcesses() {
		if (head == null) {
			System.out.println("No processes to display");
			return;
		}

		Node temp = head;
		System.out.println("--------- Process List ---------");

		do {
			System.out.println("Process ID : " + temp.data.processId);
			System.out.println("Burst Time : " + temp.data.burstTime);
			System.out.println("Priority   : " + temp.data.priority);
			System.out.println("--------------------------------");
			temp = temp.next;
		} while (temp != head);
	}
	public static void main(String[] args) {

		Process process1 = new Process(1, 10, 1);
		Process process2 = new Process(2, 5, 2);
		Process process3 = new Process(3, 8, 1);
		Process process4 = new Process(4, 6, 3);
        //insert node
		insertProcess(process1);
		insertProcess(process2);
		insertProcess(process3);
		insertProcess(process4);
        //display all processes
		displayProcesses();

		roundRobin(3);
	}
}
