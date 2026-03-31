package CinemaTime;
import java.util.*;

public class CinemaManager {
	//List for movie titles and List for showtimes
	private List<String> movieTitles = new ArrayList<>();
	private List<String> showTimes = new ArrayList<>();

	//method to validate time format
	public void validateTime(String time) throws InvalidTimeFormatException {

		if (!time.contains(":")) {
			throw new InvalidTimeFormatException("Invalid time format! Use HH:MM");
		}

		String[] parts = time.split(":");

		if (parts.length != 2) {
			throw new InvalidTimeFormatException("Invalid time format! Use HH:MM");
		}

		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
			throw new InvalidTimeFormatException("Invalid showtime! Enter valid time like 09:30");
		}
	}

	//method to add movie
	public void addMovie(String title, String time) throws InvalidTimeFormatException {

		//time validation
		validateTime(time);

		movieTitles.add(title);
		showTimes.add(time);

		System.out.println("Movie added successfully!");
		System.out.println("------------------------------------------------------");
	}

	//method to display all movies
	public void displayAllMovies() {
		if (movieTitles.isEmpty()) {
			System.out.println("No movies available!");
			System.out.println("------------------------------------------------------");
			return;
		}

		System.out.println("\n------------ Movie Schedule List ------------");
		for (int i = 0; i < movieTitles.size(); i++) {
			String formatted = String.format("%d. %s  |  Showtime: %s",
					(i + 1), movieTitles.get(i), showTimes.get(i));
			System.out.println(formatted);
		}
		System.out.println("------------------------------------------------------");
	}

	//method to search movie using keyword
	public void searchMovie(String keyword) {
		if (movieTitles.isEmpty()) {
			System.out.println("Movie list is empty!");
			System.out.println("------------------------------------------------------");
			return;
		}

		System.out.println("\nSearch Results:");
		boolean found = false;

		for (int i = 0; i < movieTitles.size(); i++) {
			if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {

				try {
					//handle IndexOutOfBoundsException for invalid search indices
					String formatted = String.format("%d. %s  |  Showtime: %s",
							(i + 1), movieTitles.get(i), showTimes.get(i));
					System.out.println(formatted);
					found = true;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Invalid index found while searching!");
				}
			}
		}

		if (!found)
			System.out.println("No movie found with keyword: " + keyword);

		System.out.println("------------------------------------------------------");
	}

	//method to convert list to array for report
	public void generateReport() {
		if (movieTitles.isEmpty()) {
			System.out.println("No data to generate report!");
			System.out.println("------------------------------------------------------");
			return;
		}
		//convert list to array when generating printable reports
		String[] titleArray = movieTitles.toArray(new String[0]);
		String[] timeArray = showTimes.toArray(new String[0]);

		System.out.println("\n------------ Printable Report ------------");
		for (int i = 0; i < titleArray.length; i++) {
			System.out.println((i + 1) + ". " + titleArray[i] + " | " + timeArray[i]);
		}
		System.out.println("------------------------------------------------------");
	}
}
