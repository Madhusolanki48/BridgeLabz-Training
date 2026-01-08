package linkedlist;
// Using Circular Linked List

class Ticket {
	//attributes
	int ticketId;
	String customerName;
	String movieName;
	int seatNumber;
	String bookingTime;
	//constructor
	Ticket(int ticketId, String customerName, String movieName,
	       int seatNumber, String bookingTime) {
		this.ticketId = ticketId;
		this.customerName = customerName;
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.bookingTime = bookingTime;
	}
}
class Node {
	Ticket data;
	Node next;
	Node(Ticket data) {
		this.data = data;
		this.next = null;
	}
}
public class OnlineTicketReservationSystem {
	static Node head = null;

	//add a new ticket reservation at the end
	static void bookTicket(Ticket ticket) {
		Node newNode = new Node(ticket);

		if (head == null) {
			head = newNode;
			newNode.next = head;
			System.out.println("Ticket booked successfully");
			return;
		}

		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = head;
		System.out.println("Ticket booked successfully");
	}

	//remove a ticket by ticket ID
	static void cancelTicket(int ticketId) {
		if (head == null) {
			System.out.println("No tickets available");
			return;
		}
		Node curr = head;
		Node prev = null;

		do {
			if (curr.data.ticketId == ticketId) {
				//if only one ticket exists
				if (curr == head && curr.next == head) {
					head = null;
					System.out.println("Ticket cancelled successfully");
					return;
				}
				//if head ticket is removed
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

				System.out.println("Ticket cancelled successfully");
				return;
			}
			prev = curr;
			curr = curr.next;

		} while (curr != head);
		System.out.println("Ticket not found");
	}

	//search ticket by customer name
	static void searchByCustomerName(String name) {
		if (head == null) {
			System.out.println("No tickets available");
			return;
		}
		Node temp = head;
		boolean found = false;

		do {
			if (temp.data.customerName.equalsIgnoreCase(name)) {
				displayTicket(temp);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);
		if (!found)
			System.out.println("Ticket not found");
	}
	//search ticket by movie name
	static void searchByMovieName(String movie) {
		if (head == null) {
			System.out.println("No tickets available");
			return;
		}
		Node temp = head;
		boolean found = false;

		do {
			if (temp.data.movieName.equalsIgnoreCase(movie)) {
				displayTicket(temp);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);
		if (!found)
			System.out.println("Ticket not found");
	}

	//display all booked tickets
	static void displayTickets() {
		if (head == null) {
			System.out.println("No tickets to display");
			return;
		}
		Node temp = head;
		System.out.println("--------- Booked Tickets ---------");
		do {
			displayTicket(temp);
			temp = temp.next;
		} while (temp != head);
	}

	//calculate total number of booked tickets
	static void countTickets() {
		if (head == null) {
			System.out.println("Total booked tickets: 0");
			return;
		}

		int count = 0;
		Node temp = head;

		do {
			count++;
			temp = temp.next;
		} while (temp != head);

		System.out.println("Total booked tickets: " + count);
	}
	static void displayTicket(Node node) {
		System.out.println("Ticket ID     : " + node.data.ticketId);
		System.out.println("Customer Name : " + node.data.customerName);
		System.out.println("Movie Name    : " + node.data.movieName);
		System.out.println("Seat Number   : " + node.data.seatNumber);
		System.out.println("Booking Time  : " + node.data.bookingTime);
		System.out.println("----------------------------------");
	}
	public static void main(String[] args) {
		Ticket ticket1 = new Ticket(101, "Alice", "Inception", 12, "10:30 AM");
		Ticket ticket2 = new Ticket(102, "Bob", "Inception", 15, "10:35 AM");
		Ticket ticket3 = new Ticket(103, "Charlie", "Avatar", 20, "11:00 AM");
		Ticket ticket4 = new Ticket(104, "Diana", "Avatar", 25, "11:05 AM");
        //book ticket
		bookTicket(ticket1);
		bookTicket(ticket2);
		bookTicket(ticket3);
		bookTicket(ticket4);
       //display all tickets
		displayTickets();
        //search
		searchByCustomerName("Alice");
		searchByMovieName("Avatar");
        //cancel ticket
		cancelTicket(102);
		displayTickets();

		countTickets();
	}
}
