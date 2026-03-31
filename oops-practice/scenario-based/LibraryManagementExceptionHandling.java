package scenario_based;
import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

//book class
class Book {
    String title;
    String author;
    boolean isAvailable;
   //constructor
    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    //getter methods
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getAvailability() {
        return isAvailable;
    }

    //method to check availability of books
    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book is already checked out");
        }
        isAvailable = false;
    }

    public String toString() {
        return String.format("Title: %-20s Author: %-15s Status: %s",title, author, isAvailable ? "Available" : "Checked Out");
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    //load books from array
    public void loadBooks(Book[] bookArray) {
        for (Book b : bookArray) {
            books.add(b);
        }
    }

    //display all books
    public void displayBooks() {
        System.out.println("\n Library Books");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    //method to search by partial title
    public void searchByTitle(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found!");
        }
    }

    //method to checkout a book
    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.checkout();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class LibraryManagementExceptionHandling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] bookArray = {  //list to store book details
        		new Book("Thinking, Fast and Slow", "Daniel Kahneman", true),
        		new Book("Man's Search for Meaning", "Viktor Frankl", true),
        		new Book("The Psychology of Learning", "B.F. Skinner", false)};
        Library library = new Library();
        library.loadBooks(bookArray);
        System.out.println("--------- Library Management System ---------");

        while (true) {
            System.out.println("\n1 - View All Books");
            System.out.println("2 - Search Book by Title");
            System.out.println("3 - Checkout a Book");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:   //display books  
                    library.displayBooks();
                    break;

                case 2:   //search book
                    System.out.print("Enter title keyword: ");
                    String keyword = sc.nextLine();
                    library.searchByTitle(keyword);
                    break;

                case 3:  //checkout a book
                    System.out.print("Enter exact book title to checkout: ");
                    String title = sc.nextLine();
                    try {
                        library.checkoutBook(title);
                    } catch (BookNotAvailableException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    break;

                case 4:   //exit
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
