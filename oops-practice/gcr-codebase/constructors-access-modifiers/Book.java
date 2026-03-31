package constructors_access_modifiers;
// Class to store book details
public class Book {
	//attributes
	private String title, author;
	private int price;
	//default constructor
	Book(){
		title="The Power of Your Subconscious Mind";
		author="Joseph Murphy";
		price=289;
		
	}
	//parameterized constructor
	Book(String title,String author,int price){
		this.title=title;
		this.author=author;
		this.price=price;
	}
	//method to display details
	void display() {
		System.out.println("The details of book :");
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Price: "+price);
		System.out.println("----------------------------------------------");
	}
	
	public static void main(String[] args) {
        Book book1=new Book();
        Book book2=new Book("One Indian Girl","Chetan Bhagat",178);
        book1.display();
        book2.display();
	}
}

