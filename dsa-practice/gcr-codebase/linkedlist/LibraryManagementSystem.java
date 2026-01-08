package linkedlist;
// Using Doubly Linked List
class Book {
	//attributes
	String title;
	String author;
	String genre;
	int bookId;
	boolean isAvailable;
    //constructor
	Book(int bookId, String title, String author, String genre, boolean isAvailable) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isAvailable = isAvailable;
	}
}

class Node {
	Book data;
	Node next;
	Node prev;
	Node(Book data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class LibraryManagementSystem {
	//head and tail pointers
	static Node head = null;
	static Node tail = null;
	//add a book at the beginning of the list.
	static void insertAtBeginning(Book book) {
		Node newNode = new Node(book);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	 //add a book at the end of the list
	static void insertAtEnd(Book book) {
		Node newNode = new Node(book);

		if (head == null) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}

	//add a book at a specific position
	static void insertAtPosition(Book book, int position) {
		if (position <= 1 || head == null) {
			insertAtBeginning(book);
			return;
		}

		Node temp = head;
		for (int i = 1; i < position - 1 && temp.next != null; i++) {
			temp = temp.next;
		}

		if (temp.next == null) {
			insertAtEnd(book);
			return;
		}

		Node newNode = new Node(book);
		newNode.next = temp.next;
		newNode.prev = temp;
		temp.next.prev = newNode;
		temp.next = newNode;
	}

	//remove a book using book ID.
	static void deleteByBookId(int bookId) {
		if (head == null) {
			System.out.println("Library is empty");
			return;
		}
		Node temp = head;
		while (temp != null && temp.data.bookId != bookId) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Book not found");
			return;
		}

		if (temp == head) {
			head = head.next;
			if (head != null)
				head.prev = null;
			else
				tail = null;
		} else if (temp == tail) {
			tail = tail.prev;
			tail.next = null;
		} else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}

		System.out.println("Book removed successfully");
	}

	//search a book by title
	static void searchByTitle(String title) {
		Node temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.data.title.equalsIgnoreCase(title)) {
				displayBook(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("Book not found");
	}
	//search a book by author
	static void searchByAuthor(String author) {
		Node temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.data.author.equalsIgnoreCase(author)) {
				displayBook(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("Book not found");
	}

	//update availability status using book ID
	static void updateAvailability(int bookId, boolean status) {
		Node temp = head;

		while (temp != null && temp.data.bookId != bookId) {
			temp = temp.next;
		}
		if (temp != null) {
			temp.data.isAvailable = status;
			System.out.println("Availability updated");
		} else {
			System.out.println("Book not found");
		}
	}
	//display books in forward order
	static void displayForward() {
		Node temp = head;
		System.out.println("----- Library Books : Forward -----");

		while (temp != null) {
			displayBook(temp);
			temp = temp.next;
		}
	}

	//display books in reverse order
	static void displayReverse() {
		Node temp = tail;
		System.out.println("----- Library Books : Reverse -----");

		while (temp != null) {
			displayBook(temp);
			temp = temp.prev;
		}
	}
	//count total number of books
	static void countBooks() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		System.out.println("Total number of books: " + count);
	}
	static void displayBook(Node node) {
		System.out.println("Book ID      : " + node.data.bookId);
		System.out.println("Title        : " + node.data.title);
		System.out.println("Author       : " + node.data.author);
		System.out.println("Genre        : " + node.data.genre);
		System.out.println("Available    : " + (node.data.isAvailable ? "Yes" : "No"));
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		Book book1 = new Book(1, "Java Basics", "James Gosling", "Programming", true);
		Book book2 = new Book(2, "Clean Code", "Robert Martin", "Software", true);
		Book book3 = new Book(3, "Python Guide", "Guido van Rossum", "Programming", false);
		Book book4 = new Book(4, "Data Structures", "Mark Allen", "CS", true);
        //insert node
		insertAtEnd(book1);
		insertAtEnd(book2);
		insertAtBeginning(book3);
		insertAtPosition(book4, 2);
        //display
		displayForward();
		displayReverse();
        //search
		searchByTitle("Clean Code");
		searchByAuthor("James Gosling");
        //update
		updateAvailability(3, true);
		//delete
		deleteByBookId(2);
 
		displayForward();
		countBooks();
	}
}
