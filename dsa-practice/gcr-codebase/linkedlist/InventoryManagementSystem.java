package linkedlist;
//Using Singly Linked List
class Item {
	//attributes
	int itemId;
	String itemName;
	int quantity;
	double price;
	//constructor
	Item(int itemId, String itemName, int quantity, double price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
}
class Node {
	Item data;
	Node next;

	Node(Item data) {
		this.data = data;
		this.next = null;
	}
}
public class InventoryManagementSystem {
	static Node head = null;

	//add an item at the beginning
	static void insertAtBeginning(Item item) {
		Node newNode = new Node(item);
		newNode.next = head;
		head = newNode;
	}

	//add an item at end
	static void insertAtEnd(Item item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	//add an item at specific position
	static void insertAtPosition(Item item, int position) {
		if (position <= 1 || head == null) {
			insertAtBeginning(item);
			return;
		}
		Node temp = head;
		for (int i = 1; i < position - 1 && temp.next != null; i++) {
			temp = temp.next;
		}
		Node newNode = new Node(item);
		newNode.next = temp.next;
		temp.next = newNode;
	}

	//remove an item based on item ID
	static void deleteByItemId(int itemId) {
		if (head == null) {
			System.out.println("Inventory is empty");
			return;
		}

		if (head.data.itemId == itemId) {
			head = head.next;
			System.out.println("Item removed successfully");
			return;
		}
		Node temp = head;
		while (temp.next != null && temp.next.data.itemId != itemId) {
			temp = temp.next;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
			System.out.println("Item removed successfully");
		} else {
			System.out.println("Item not found");
		}
	}

	//update the quantity of an item by item ID.
	static void updateQuantity(int itemId, int newQuantity) {
		Node temp = head;
		while (temp != null && temp.data.itemId != itemId) {
			temp = temp.next;
		}

		if (temp != null) {
			temp.data.quantity = newQuantity;
			System.out.println("Quantity updated successfully");
		} else {
			System.out.println("Item not found");
		}
	}

	//search for an item based on item ID
	static void searchByItemId(int itemId) {
		Node temp = head;

		while (temp != null && temp.data.itemId != itemId) {
			temp = temp.next;
		}

		if (temp != null) {
			displayItem(temp);
		} else {
			System.out.println("Item not found");
		}
	}
	//search for an item based on item name
	static void searchByItemName(String name) {
		Node temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.data.itemName.equalsIgnoreCase(name)) {
				displayItem(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("Item not found");
	}
	//calculate total inventory value
	static void calculateTotalValue() {
		Node temp = head;
		double total = 0;
		while (temp != null) {
			total += temp.data.price * temp.data.quantity;
			temp = temp.next;
		}
		System.out.println("Total Inventory Value: " + total);
	}
	//sort the inventory based on item name
	static void sortByName(boolean ascending) {
		if (head == null)
			return;

		for (Node i = head; i.next != null; i = i.next) {
			for (Node j = i.next; j != null; j = j.next) {
				int cmp = i.data.itemName.compareToIgnoreCase(j.data.itemName);
				if ((ascending && cmp > 0) || (!ascending && cmp < 0)) {
					Item temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
		System.out.println("Inventory sorted by name");
	}
	//sort the inventory based on price
	static void sortByPrice(boolean ascending) {
		if (head == null)
			return;
		for (Node i = head; i.next != null; i = i.next) {
			for (Node j = i.next; j != null; j = j.next) {
				if ((ascending && i.data.price > j.data.price) || (!ascending && i.data.price < j.data.price)) {
					Item temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
		System.out.println("Inventory sorted by price");
	}

	//display all items
	static void displayInventory() {
		Node temp = head;
		System.out.println("----------- Inventory ----------");
		while (temp != null) {
			displayItem(temp);
			temp = temp.next;
		}
	}
	static void displayItem(Node node) {
		System.out.println("Item ID   : " + node.data.itemId);
		System.out.println("Name      : " + node.data.itemName);
		System.out.println("Quantity  : " + node.data.quantity);
		System.out.println("Price     : " + node.data.price);
		System.out.println("--------------------------------");
	}
	public static void main(String[] args) {
		Item item1 = new Item(101, "Laptop", 5, 50000);
		Item item2 = new Item(102, "Mouse", 20, 500);
		Item item3 = new Item(103, "Keyboard", 10, 1500);
		Item item4 = new Item(104, "Monitor", 7, 12000);
		//insert items
		insertAtEnd(item1);
		insertAtEnd(item2);
		insertAtBeginning(item3);
		insertAtPosition(item4, 2);
		//display items
		displayInventory();
		//update
		updateQuantity(102, 25);
		//search
		searchByItemId(103);
		searchByItemName("Laptop");

		calculateTotalValue();
        //sort by name
		sortByName(true);
		displayInventory();
        //sort by price
		sortByPrice(false);
		displayInventory();
        //delete
		deleteByItemId(101);
		displayInventory();
	}
}
