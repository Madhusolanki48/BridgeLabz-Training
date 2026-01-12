package StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.Scanner;

//main class
public class StudentCourseRegistrationSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//course catalog
		ArrayList<Course> courses = new ArrayList<>();
		courses.add(new Course(101, "Java Programming", 4));
		courses.add(new Course(102, "DBMS", 3));
		courses.add(new Course(103, "Computer Networks", 3));
		courses.add(new Course(104, "Operating System", 4));
		courses.add(new Course(105, "Web Development", 3));
		System.out.println("--- Welcome to Student Course Registration System ---");

		//register student
		System.out.print("\nEnter Student Id: ");
		int sid = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Student Name: ");
		String sname = sc.nextLine();
		System.out.print("Enter Student Phone: ");
		String phone = sc.nextLine();
		Student student = new Student(sid, sname, phone);
		//create service
		RegistrationService service = new CourseRegistrationService();

		while (true) {
			System.out.println("\n----------- Home Page -----------");
			System.out.println("1. View Course Catalog");
			System.out.println("2. Enroll in Course");
			System.out.println("3. Drop Course");
			System.out.println("4. View Enrolled Courses");
			System.out.println("5. Assign Grade");
			System.out.println("6. View Grades");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			if (choice == 0) {
				System.out.println("Exiting... Thank you!");
				break;
			}
			switch (choice) {
			
			case 1:
				System.out.println("\n----- Course Catalog -----");
				for (Course c : courses)
					System.out.println(c);
				break;

			case 2:
				System.out.print("\nEnter Course Id to Enroll: ");
				int courseIdEnroll = sc.nextInt();

				Course selectedEnroll = null;
				for (Course c : courses) {
					if (c.getId() == courseIdEnroll) {
						selectedEnroll = c;
						break;
					}
				}

				try {
					if (selectedEnroll != null) {
						service.enrollCourse(student, selectedEnroll);
						System.out.println("Course Enrolled Successfully!");
					} else {
						System.out.println("Invalid Course Id!");
					}
				} catch (CourseLimitExceededException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 3:
				System.out.print("\nEnter Course Id to Drop: ");
				int courseIdDrop = sc.nextInt();
				service.dropCourse(student, courseIdDrop);
				break;

			case 4:
				student.displayEnrolledCourses();
				break;

			case 5:
				System.out.print("\nEnter Course Id to Assign Grade: ");
				int gradeCourseId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Grade (A/B/C/D/F): ");
				String grade = sc.nextLine();
				service.assignGrade(student, gradeCourseId, grade);
				break;

			case 6:
				student.displayGrades();
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
