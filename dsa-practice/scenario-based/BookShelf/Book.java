package BookShelf;
import java.util.*;
//Book class storing book data
class Book {
	//attributes
    String title;
    String author;
    //constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " (" + author + ")";
    }

    //prevent duplication for same title + author
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        return this.title.equalsIgnoreCase(b.title) &&
               this.author.equalsIgnoreCase(b.author);
    }

    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase());
    }
}
