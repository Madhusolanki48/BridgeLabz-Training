package LibraryManagementSystem;

public class UserFactory {
	public static User createUser(String type, String name) {
		if (type == null || type.trim().isEmpty()) {
			throw new IllegalArgumentException("User type cannot be empty");
		}

		switch (type.trim().toLowerCase()) {
		case "student":
			return new Student(name);
		case "faculty":
			return new Faculty(name);
		case "librarian":
			return new Librarian(name);
		default:
			throw new IllegalArgumentException("Unknown user type: " + type);
		}
	}
}