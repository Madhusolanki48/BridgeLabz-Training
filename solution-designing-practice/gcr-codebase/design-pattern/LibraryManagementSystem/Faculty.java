package LibraryManagementSystem;

public class Faculty extends User {
	public Faculty(String name) {
		super(name);
	}

	@Override
	public void showRole() {
		System.out.println(name + " is a Faculty member.");
	}
}
