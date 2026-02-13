package OnlineCourseEnrollmentManager;

import java.util.Scanner;

//main class
public class CourseManagerApp {
	public static void main(String[] args) {
		EnrollmentService service = new EnrollmentService();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n----- ONLINE COURSE ENROLLMENT MANAGER ------");
			System.out.println("1. Filter by Course");
			System.out.println("2. Filter by Category");
			System.out.println("3. Group by Course");
			System.out.println("4. Count by Category");
			System.out.println("5. Sort by Enrollment Date");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter course name: ");
				String course = sc.nextLine();
				service.filterByCourse(course).forEach(System.out::println);
				break;

			case 2:
				System.out.print("Enter category: ");
				String category = sc.nextLine();

				service.filterByCategory(category).forEach(System.out::println);
				break;

			case 3:
				service.groupByCourse().forEach((c, list) -> {
					System.out.println("\n" + c);
					list.forEach(System.out::println);
				});
				break;

			case 4:
				service.countByCategory().forEach((cat, count) -> System.out.println(cat + " : " + count));
				break;

			case 5:
				service.sortByDate().forEach(System.out::println);
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);
	}
}
