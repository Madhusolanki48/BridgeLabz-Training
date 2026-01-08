package linkedlist;
//Using Doubly Linked List

class TextState {
	//attribute
	String content;
	//constructor
	TextState(String content) {
		this.content = content;
	}
}

class Node {
	TextState data;
	Node next;
	Node prev;
	Node(TextState data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class UndoRedoFunctionalityTextEditor {
	static Node head = null;
	static Node tail = null;
	static Node current = null;
	static int stateCount = 0;
	static final int MAX_HISTORY = 10;

	//add a new text state
	static void addState(String text) {
		Node newNode = new Node(new TextState(text));
		//if first state
		if (head == null) {
			head = tail = current = newNode;
			stateCount = 1;
			System.out.println("Added Text   : " + text);
			return;
		}

		//remove redo history
		if (current.next != null) {
			current.next.prev = null;
			current.next = null;
			tail = current;
		}

		//add new state at end
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		current = newNode;
		stateCount++;

		//limit history size
		if (stateCount > MAX_HISTORY) {
			head = head.next;
			head.prev = null;
			stateCount--;
		}
		System.out.println("Added Text   : " + text);
	}

	//undo operation
	static void undo() {
		if (current == null || current.prev == null) {
			System.out.println("Nothing to undo");
			return;
		}
		current = current.prev;
		System.out.print("Undo -> ");
		displayCurrentState();
	}

	//redo operation
	static void redo() {
		if (current == null || current.next == null) {
			System.out.println("Nothing to redo");
			return;
		}
		current = current.next;
		System.out.print("Redo -> ");
		displayCurrentState();
	}

	//display the current state of the text
	static void displayCurrentState() {
		if (current != null) {
			System.out.println("Current Text: " + current.data.content);
		}
	}

	public static void main(String[] args) {
		//add
		addState("Java");
		addState("Java Programming");
		addState("Java Programming!");
		addState("Java Programming!!");
		undo();
		undo();
		redo();
		addState("Java Developers");
		undo();
		redo();
	}
}
