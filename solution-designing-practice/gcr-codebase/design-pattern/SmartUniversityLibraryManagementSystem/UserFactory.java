package SmartUniversityLibraryManagementSystem;

public class UserFactory {
	public static User createUser(String role, String name) {
		return switch (role.trim().toLowerCase()) {
		case "student" -> new Student(name);
		case "faculty" -> new Faculty(name);
		case "librarian" -> new Librarian(name);
		default -> throw new IllegalArgumentException("Unknown role: " + role);
		};
	}
}