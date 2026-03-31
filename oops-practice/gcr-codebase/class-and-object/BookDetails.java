package class_and_object;
// Class to store book details
class Book {
	//attributes
    private String title;   
    private String author;
    private double price;
    //constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    //method to display details
    public void display() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Book book1 = new Book("2States", "Chetan Bhagat", 500);
        Book book2 = new Book("Wings Of Fire", "Abdul Kalam.A.P.J", 500);
        book1.display();
        book2.display();
    }
}