package scenario_based;
import java.util.*;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		System.out.println("--------- Welcome to Library Management System ---------");
		System.out.println("--------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        while (true) {
        	
            displayBooks();
            //user input
            System.out.print("\nEnter book title keyword to search (or 'exit'): ");
            String key = sc.nextLine();
            if (key.equalsIgnoreCase("exit"))
            	break;
            int index = searchBook(key);

            if (index == -1) {
                System.out.println("No book found with matching title!");
                continue;
            }

            System.out.println("\nFOUND: " + titles[index] + " — " + authors[index]);
            System.out.println("Current Status: " + status[index]);
            System.out.print("Do you want to toggle checkout/return? (yes/no): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                updateCheckout(index);
            }
        }

        System.out.println("\nLibrary System Closed. Thank You!");
    }
	//store book data in an array
    static String[] titles  = {"Java Basics", "Data Structures", "Python Guide", "Let Us C"};
    static String[] authors = {"James", "Narasimha", "Mark", "Yashavant Kanetkar"};
    static String[] status  = {"available", "available", "checked out", "available"};

    //method to display all books
    public static void displayBooks() {
        System.out.println("\nLibrary Books List");
        for (int i = 0; i < titles.length; i++) {
            System.out.println((i+1) + ". " + titles[i] + " — " + authors[i] +
                               " | Status: " + status[i]);
        }
    }

    //method to search by partial title
    public static int searchBook(String keyword) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    //method to update book status
    public static void updateCheckout(int index) {
        if (status[index].equalsIgnoreCase("available")) {
            status[index] = "checked out";
            System.out.println("Book checked out successfully!");
        } else {
            status[index] = "available";
            System.out.println("Book returned and marked available!");
        }
    }
}

