package inheritance;
// Single Inheritance
// Sample Problem 1: Library Management with Books and Authors
class Book { //superclass
	//attributes
	String title;
	int publicationYear;

	Book(String title,int publicationYear){
		this.title=title;
		this.publicationYear=publicationYear;
	}
}

class Author extends Book { //subclass
	String name;
	String bio;

	Author(String title,int pubYear,String name,String bio){
		super(title,pubYear);
		this.name=name;
		this.bio=bio;
	}

	void displayInfo(){ //method to show details of the book and its author.
		System.out.println("Book Title : "+title);
		System.out.println("Publication Year : "+publicationYear);
		System.out.println("Author Name : "+name);
		System.out.println("Bio : "+bio);
		
	}
}

public class LibraryManagement {
	public static void main(String[] args) {
		Author book=new Author("Let Us C",2006,"Yashavant Kanetkar","Software Author");
		book.displayInfo();
	}
}

