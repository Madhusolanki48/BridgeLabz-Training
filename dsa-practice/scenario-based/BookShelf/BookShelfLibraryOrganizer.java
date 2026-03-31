package BookShelf;
import java.util.*;

public class BookShelfLibraryOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookShelf shelf = new BookShelf();

        System.out.println("-------------  BookShelf Library Organizer  ------------");

        while (true) {
            System.out.println("\n1- Add Book");
            System.out.println("2- Borrow Book");
            System.out.println("3- Return Book");
            System.out.println("4- Display Catalog");
            System.out.println("5- Exit");
            System.out.println("------------------------------------------------------");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    boolean added =shelf.addBook(genre, new Book(title, author));
                    if (added)
                    	System.out.println("Book added successfully!");
                    else
                    	System.out.println("Duplicate book not allowed!");
                    break;

                case 2:
                    System.out.print("Enter Genre: ");
                    String g1 = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String t1 = sc.nextLine();
                    shelf.borrowBook(g1, t1);
                    break;

                case 3:
                    System.out.print("Enter Genre: ");
                    String g2 = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String t2 = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String a2 = sc.nextLine();
                    boolean returned = shelf.returnBook(g2, new Book(t2, a2));
                    if (returned)
                        System.out.println("Book returned successfully!");
                    else
                        System.out.println("Duplicate book not allowed!");
                    break;

                case 4:
                    shelf.displayCatalog();
                    break;

                case 5:
                    System.out.println("Library Organizer Closed!");
                    System.out.println("Thank you! Visit again...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
