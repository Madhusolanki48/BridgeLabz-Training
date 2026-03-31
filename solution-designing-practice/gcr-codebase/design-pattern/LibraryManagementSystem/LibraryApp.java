package LibraryManagementSystem;

public class LibraryApp {
	public static void main(String[] args) {
		//get the single catalog instance
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		//create users using Factory
		User alice = UserFactory.createUser("student", "Alice");
		User bob = UserFactory.createUser("faculty", "Dr. Bob");
		User sarita = UserFactory.createUser("librarian", "Sarita");

		//show roles
		System.out.println("Registered users:");
		alice.showRole();
		bob.showRole();
		sarita.showRole();
		System.out.println();

		//subscribe to notifications
		catalog.addObserver(alice);
		catalog.addObserver(bob);
		//sarita is librarian ->maybe doesn't want book arrival spam

		// Add books using Builder
		Book book1 = new Book.BookBuilder("Clean Code").author("Robert C. Martin").edition("1st").genre("Programming")
				.build();

		Book book2 = new Book.BookBuilder("The Pragmatic Programmer").author("Andrew Hunt & David Thomas")
				.genre("Software Development").build(); // no edition specified -> optional

		// Adding books -> triggers notifications
		System.out.println("Adding new books to catalog...");
		catalog.addBook(book1);
		catalog.addBook(book2);

		System.out.println("\nCurrent catalog contents:");
		for (Book b : catalog.getAllBooks()) {
			System.out.println("• " + b);
		}
	}
}