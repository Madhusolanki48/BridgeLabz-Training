package LibraryManagementSystem;

public class Librarian extends User {
	public Librarian(String name) {
		super(name);
	}

	@Override
	public void showRole() {
		System.out.println(name + " is a Librarian.");
	}
}