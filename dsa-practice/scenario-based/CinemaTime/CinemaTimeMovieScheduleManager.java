package CinemaTime;
import java.util.*;

public class CinemaTimeMovieScheduleManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CinemaManager manager = new CinemaManager();
		System.out.println("--------- CinemaTime – Movie Schedule Manager ---------");
		System.out.println("------------------------------------------------------");

		while (true) {
			System.out.println("\n1- Add Movie");
			System.out.println("2- View All Movies");
			System.out.println("3- Search Movie");
			System.out.println("4- Generate Printable Report");
			System.out.println("5- Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {

			case 1:
				System.out.print("Enter movie title: ");
				String title = sc.nextLine();

				System.out.print("Enter showtime (HH:MM): ");
				String time = sc.nextLine();

				try {
					manager.addMovie(title, time);
				} catch (InvalidTimeFormatException e) {
					System.out.println("Error: " + e.getMessage());
					System.out.println("------------------------------------------------------");
				}
				break;

			case 2:
				manager.displayAllMovies();
				break;

			case 3:
				System.out.print("Enter keyword to search: ");
				String keyword = sc.nextLine();
				manager.searchMovie(keyword);
				break;

			case 4:
				manager.generateReport();
				break;

			case 5:
				System.out.println("------------------------------------------------------");
				System.out.println("CinemaTime Closed. Thank you!");
				System.out.println("------------------------------------------------------");
				return;

			default:
				System.out.println("Invalid choice! Please try again.");
				System.out.println("------------------------------------------------------");
			}
		}
	}
}
