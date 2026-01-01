package this_static_final;
//Program 2: Library Management System
public class Book {
    //static variable shared across all books
    private static String libraryName = "Egmore Library";
    //final variable
    private final String isbn;
    //instance variables
    private String title;
    private String author;
    //constructor using 'this'
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    //static method
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    //display book details using instanceof
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid Book Object");
        }
    }
    //main method
    public static void main(String[] args) {
        Book book = new Book("Effective Java","Joshua Bloch","978-0134685991");
        //display library and book details
        Book.displayLibraryName();
        book.displayBookDetails();
    }
}
