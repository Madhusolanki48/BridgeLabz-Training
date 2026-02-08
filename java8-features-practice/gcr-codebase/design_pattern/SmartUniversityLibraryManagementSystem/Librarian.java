package SmartUniversityLibraryManagementSystem;

public class Librarian extends User {
	public Librarian(String name) {
		super(name);
	}

	@Override
	public void showRole() {
		System.out.println(name + " → Librarian (full admin access)");
	}
}