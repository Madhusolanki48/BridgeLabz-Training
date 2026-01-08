package linkedlist;
//Using Singly Linked List
class User {
	//attributes
	int userId;
	String name;
	int age;
	int[] friends; //list of friend IDs
	int friendCount;

	// constructor
	User(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.friends = new int[10]; //max 10 friends
		this.friendCount = 0;
	}
}
class Node {
	User data;
	Node next;
	Node(User data) {
		this.data = data;
		this.next = null;
	}
}

public class SocialMediaFriendConnections {
	//head pointer
	static Node head = null;
	//add a user to the list
	static void addUser(User user) {
		Node newNode = new Node(user);

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

	//add friend connection between two users
	static void addFriend(int userId1, int userId2) {
		Node user1 = findUser(userId1);
		Node user2 = findUser(userId2);

		if (user1 == null || user2 == null) {
			System.out.println("User not found");
			return;
		}

		user1.data.friends[user1.data.friendCount++] = userId2;
		user2.data.friends[user2.data.friendCount++] = userId1;

		System.out.println("Friend connection added");
	}

	//remove friend connection
	static void removeFriend(int userId1, int userId2) {
		Node user1 = findUser(userId1);
		Node user2 = findUser(userId2);

		if (user1 == null || user2 == null) {
			System.out.println("User not found");
			return;
		}

		removeFriendFromList(user1.data, userId2);
		removeFriendFromList(user2.data, userId1);

		System.out.println("Friend connection removed");
	}

	//find mutual friends between two users
	static void findMutualFriends(int userId1, int userId2) {
		Node user1 = findUser(userId1);
		Node user2 = findUser(userId2);

		if (user1 == null || user2 == null) {
			System.out.println("User not found");
			return;
		}
		System.out.println("Mutual Friends:");
		boolean found = false;
		for (int i = 0; i < user1.data.friendCount; i++) {
			for (int j = 0; j < user2.data.friendCount; j++) {
				if (user1.data.friends[i] == user2.data.friends[j]) {
					System.out.println("Friend ID: " + user1.data.friends[i]);
					found = true;
				}
			}
		}
		if (!found)
			System.out.println("No mutual friends");
	}

	//display all friends of a specific user
	static void displayFriends(int userId) {
		Node user = findUser(userId);

		if (user == null) {
			System.out.println("User not found");
			return;
		}
		System.out.println("Friends of " + user.data.name + ":");
		if (user.data.friendCount == 0) {
			System.out.println("No friends");
			return;
		}
		for (int i = 0; i < user.data.friendCount; i++) {
			System.out.println("Friend ID: " + user.data.friends[i]);
		}
	}

	//search for a user by ID
	static void searchByUserId(int userId) {
		Node temp = head;
		while (temp != null) {
			if (temp.data.userId == userId) {
				displayUser(temp);
				return;
			}
			temp = temp.next;
		}
		System.out.println("User not found");
	}

	//search for a user by name
	static void searchByName(String name) {
		Node temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.data.name.equalsIgnoreCase(name)) {
				displayUser(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("User not found");
	}

	//count number of friends for each user
	static void countFriends() {
		Node temp = head;
		while (temp != null) {
			System.out.println("User: " + temp.data.name + " | Number of Friends: " + temp.data.friendCount);
			temp = temp.next;
		}
	}

	//method to find a user
	static Node findUser(int userId) {
		Node temp = head;
		while (temp != null) {
			if (temp.data.userId == userId)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	//method to remove friend from list
	static void removeFriendFromList(User user, int friendId) {
		for (int i = 0; i < user.friendCount; i++) {
			if (user.friends[i] == friendId) {
				for (int j = i; j < user.friendCount - 1; j++) {
					user.friends[j] = user.friends[j + 1];
				}
				user.friendCount--;
				return;
			}
		}
	}
	static void displayUser(Node node) {
		System.out.println("User ID : " + node.data.userId);
		System.out.println("Name    : " + node.data.name);
		System.out.println("Age     : " + node.data.age);
		System.out.println("Friends : " + node.data.friendCount);
		System.out.println("----------------------------------");
	}
	public static void main(String[] args) {
		User user1 = new User(1, "Alice", 20);
		User user2 = new User(2, "Bob", 21);
		User user3 = new User(3, "Charlie", 22);
		User user4 = new User(4, "Diana", 23);
        //add user
		addUser(user1);
		addUser(user2);
		addUser(user3);
		addUser(user4);
        //add friend
		addFriend(1, 2);
		addFriend(1, 3);
		addFriend(2, 3);
        //display all friends
		displayFriends(1);
		findMutualFriends(1, 2);
       
		removeFriend(1, 3);
		displayFriends(1);

		searchByUserId(2);
		searchByName("Diana");

		countFriends();
	}
}
