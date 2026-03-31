package constructors_access_modifiers;
//Access Modifiers
//Problem 2: Book Library System
public class LibraryBook2 {
    //attributes
    public String ISBN;       //public
    protected String title;   //protected   
    private String author;    //private    

    //setter method for private author
    public void setAuthor(String author) {
        this.author = author;
    }

    //getter method for private author
    public String getAuthor() {
        return author;
    }

    //method to display complete book details
    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("----------------------------------");
    }
}

//subclass
class EBook extends LibraryBook2 {
    //accessing inherited ISBN & title
    void showDetails() {
        System.out.println("EBook Access → " + ISBN + " | " + title);
    }
    
    
    public static void main(String[] args) {
        EBook e = new EBook();

        e.ISBN = "9780061120084";                
        e.title = "To Kill a Mockingbird";   
        e.setAuthor("Harper Lee");    

        e.display();
        e.showDetails();
    }
}
