package oops_pillars;
import java.util.*;

//interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

//abstract class
abstract class LibraryItem implements Reservable {
    //encapsulated fields
    private int itemId;
    private String title;
    private String author;

    //constructor
    public LibraryItem(int itemId,String title,String author){
        this.itemId=itemId;
        this.title=title;
        this.author=author;
    }

    //abstract method
    public abstract int getLoanDuration();

    //concrete method
    public void getItemDetails(){
        System.out.println("Item ID      : "+itemId);
        System.out.println("Title        : "+title);
        System.out.println("Author       : "+author);
        System.out.println("Loan Duration: "+getLoanDuration()+" Days");
        System.out.println("------------------------------");
    }
}

//book
class Book extends LibraryItem {
    public Book(int itemId,String title,String author){
    	super(itemId,title,author);
    	}
    @Override
    public int getLoanDuration() {
    	return 14;
    	}
    @Override
    public void reserveItem() {
    	System.out.println("Book Reserved");
    	}
    @Override
    public boolean checkAvailability() {
    	return true;
    	}
}

//magazine
class Magazine extends LibraryItem {
    public Magazine(int itemId,String title,String author){
    	super(itemId,title,author);
    	}
    @Override
    public int getLoanDuration() {
    	return 7;
    	}
    @Override
    public void reserveItem() {
    	System.out.println("Magazine Reserved");
    	}
    @Override
    public boolean checkAvailability() {
    	return true;
    	}
}

//dvd
class DVD extends LibraryItem {
    public DVD(int itemId,String title,String author){
    	super(itemId,title,author);
    	}
    @Override
    public int getLoanDuration() {
    	return 3;
    	}
    @Override
    public void reserveItem() {
    	System.out.println("DVD Reserved");
    	}
    @Override
    public boolean checkAvailability() {
    	return false;
    	}
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book(1,"Atomic Habits","James Clear"));
        items.add(new Magazine(2,"Tech Today","Editorial Team"));
        items.add(new DVD(3,"Inception","Nolan"));

        //polymorphism
        for(LibraryItem item : items){
            item.getItemDetails();
        }
    }
}

