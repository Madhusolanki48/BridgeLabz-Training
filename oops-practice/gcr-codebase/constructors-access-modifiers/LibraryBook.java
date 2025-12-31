package constructors_access_modifiers;

public class LibraryBook {
	//attributes
    private String title,author;
    private double price;
    private boolean isAvailable;

    //parameterized constructor
    LibraryBook(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    //method to display book details
    void display() {
    	System.out.println("----------------------------------------------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
       
    }

    //method to borrow book
    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title+" borrowed successfully!");
        } else {
            System.out.println("Sorry, "+title+" is not available!");
        }
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Clean Code", "Robert C. Martin", 799.0, true);
        LibraryBook book2=new LibraryBook("The Alchemist","Paulo Coelho",438,true);
        LibraryBook book3=new LibraryBook("The Psychology of Money","Morgan Housel",289,false);
        
        book1.display();   
        book1.borrowBook();  
        book2.display();  
        book2.borrowBook();
        book3.display();  
        book3.borrowBook();
        
    }
}


