package SmartUniversityLibraryManagementSystem;

public class Student extends User {
	public Student(String name) {
		super(name);
	}

	@Override
	public void showRole() {
		System.out.println(name + " → Student (max 7 days borrow)");
	}
}