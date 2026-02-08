package SmartUniversityLibraryManagementSystem;

public class SmartLibraryDemo {
	public static void main(String[] args) {
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		// Factory usage
		User alice = UserFactory.createUser("student", "Alice Sharma");
		User drGupta = UserFactory.createUser("faculty", "Dr. Rajesh Gupta");
		User priya = UserFactory.createUser("librarian", "Priya Singh");

		alice.showRole();
		drGupta.showRole();
		priya.showRole();
		System.out.println();

		// Subscribe to general notifications
		catalog.registerObserver(alice);
		catalog.registerObserver(drGupta);
		// Priya (librarian) does not subscribe to spam

		// Specific book interest (waitlist)
		catalog.subscribeToBook("Introduction to Algorithms", alice);
		catalog.subscribeToBook("Introduction to Algorithms", drGupta);

		// Add books using Builder
		Book dsBook = new Book.BookBuilder("Introduction to Algorithms")
				.authors("Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein")
				.edition("4th").genre("Computer Science").publisher("MIT Press").isbn("978-0262046305").build();

		Book cleanCode = new Book.BookBuilder("Clean Code").authors("Robert C. Martin").genre("Software Engineering")
				.build();

		System.out.println("\nAdding books to catalog...\n");

		catalog.addBook(dsBook); // should trigger waitlist + general notification
		catalog.addBook(cleanCode); // only general notification

		System.out.println("\nFinal catalog:");
		for (Book b : catalog.getBooks()) {
			System.out.println("• " + b);
		}
	}
}