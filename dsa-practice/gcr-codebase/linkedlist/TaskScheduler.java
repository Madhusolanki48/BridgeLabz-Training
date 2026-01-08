package linkedlist;
//Using  Circular Linked List
class Task {
	int taskId;
	String taskName;
	int priority;
	String dueDate;
	//constructor
	Task(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
	}
}
class Node {
	Task data;
	Node next;

	Node(Task data) {
		this.data = data;
		this.next = null;
	}
}
public class TaskScheduler {
	static Node head = null;
	static Node current = null;

	//add a task at the beginning
	static void insertAtBeginning(Task task) {
		Node newNode = new Node(task);
		if (head == null) {
			head = newNode;
			newNode.next = head;
			current = head;
			return;
		}
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		newNode.next = head;
		temp.next = newNode;
		head = newNode;
	}

	//add a task at end
	static void insertAtEnd(Task task) {
		Node newNode = new Node(task);
		if (head == null) {
			head = newNode;
			newNode.next = head;
			current = head;
			return;
		}
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = head;
	}

	// add a task at specific position
	static void insertAtPosition(Task task, int position) {
		if (position <= 1 || head == null) {
			insertAtBeginning(task);
			return;
		}
		Node newNode = new Node(task);
		Node temp = head;

		for (int i = 1; i < position - 1 && temp.next != head; i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	//remove a task by task ID
	static void deleteByTaskId(int taskId) {
		if (head == null) {
			System.out.println("No tasks available");
			return;
		}

		Node temp = head;
		Node prev = null;
		do {
			if (temp.data.taskId == taskId) {
				if (temp == head && temp.next == head) {
					head = null;
					current = null;
					return;
				}
				if (temp == head) {
					Node last = head;
					while (last.next != head) {
						last = last.next;
					}
					head = head.next;
					last.next = head;
				} else {
					prev.next = temp.next;
				}
				System.out.println("Task deleted successfully");
				return;
			}
			prev = temp;
			temp = temp.next;
		} while (temp != head);
		System.out.println("Task not found");
	}

	//view the current task and move to the next task in the circular list
	static void viewCurrentTask() {
		if (current == null) {
			System.out.println("No tasks available");
			return;
		}

		System.out.println("Current Task:");
		displayTask(current);
		current = current.next;
	}

	//display all tasks in the list starting from the head node
	static void displayAllTasks() {
		if (head == null) {
			System.out.println("No tasks to display");
			return;
		}

		Node temp = head;
		System.out.println("----------- Task List -----------");

		do {
			displayTask(temp);
			temp = temp.next;
		} while (temp != head);
	}

	//search for a task by priority
	static void searchByPriority(int priority) {
		if (head == null) {
			System.out.println("No tasks available");
			return;
		}

		Node temp = head;
		boolean found = false;

		do {
			if (temp.data.priority == priority) {
				displayTask(temp);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);

		if (!found)
			System.out.println("No task found with this priority");
	}

	static void displayTask(Node node) {
		System.out.println("Task ID   : " + node.data.taskId);
		System.out.println("Task Name : " + node.data.taskName);
		System.out.println("Priority  : " + node.data.priority);
		System.out.println("Due Date  : " + node.data.dueDate);
		System.out.println("--------------------------------");
	}

	public static void main(String[] args) {
		Task task1 = new Task(1, "Design UI", 1, "08-01-2026");
		Task task2 = new Task(2, "Write Code", 2, "12-01-2026");
		Task task3 = new Task(3, "Testing", 3, "15-01-2026");
		Task task4 = new Task(4, "Deployment", 1, "20-01-2026");
        //insert node
		insertAtEnd(task1);
		insertAtEnd(task2);
		insertAtBeginning(task3);
		insertAtPosition(task4, 2);
        //display all tasks
		displayAllTasks();
        //view current task
		viewCurrentTask();
		viewCurrentTask();
        //search
		searchByPriority(1);
        //delete task
		deleteByTaskId(2);
		displayAllTasks();
	}
}
