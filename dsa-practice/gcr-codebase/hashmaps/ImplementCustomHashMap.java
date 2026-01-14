package hashmaps;

class MyHashMap {
	//node for LinkedList
	class Node {
		int key;
		int value;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int size = 10; //fixed size
	private Node[] buckets;

	//constructor
	MyHashMap() {
		buckets = new Node[size];
	}

	//hash function
	private int hash(int key) {
		return key % size;
	}

	//insert/update
	public void put(int key, int value) {
		int index = hash(key);
		Node head = buckets[index];

		//update if key exists
		while (head != null) {
			if (head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		//insert new node
		Node newNode = new Node(key, value);
		newNode.next = buckets[index];
		buckets[index] = newNode;
	}

	//get method
	public int get(int key) {
		int index = hash(key);
		Node head = buckets[index];

		while (head != null) {
			if (head.key == key) {
				return head.value;
			}
			head = head.next;
		}
		return -1; //if not found
	}

	//remove method
	public void remove(int key) {
		int index = hash(key);
		Node head = buckets[index];
		Node prev = null;

		while (head != null) {
			if (head.key == key) {
				if (prev == null) {
					buckets[index] = head.next;
				} else {
					prev.next = head.next;
				}
				return;
			}
			prev = head;
			head = head.next;
		}
	}
}

public class ImplementCustomHashMap {
	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put(1, 10);
		map.put(2, 20);
		map.put(12, 30); //collision with key 2

		System.out.println(map.get(1)); // 10
		System.out.println(map.get(2)); // 20
		System.out.println(map.get(12)); // 30

		map.remove(2);
		System.out.println(map.get(2)); // -1
	}
}