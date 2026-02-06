package stream_api;
import java.util.*;
//movie class to store movie details
class Movie {
	String name;
	int year;
	double rating;
   //constructor
	Movie(String name, int year, double rating) {
		this.name = name;
		this.year = year;
		this.rating = rating;
	}
}
//main class
public class TopTrendingMovies {
	public static void main(String[] args) {

		List<Movie> movies = Arrays.asList(new Movie("Avatar", 2023, 8.5), new Movie("Titanic", 2022, 9.0),
				new Movie("Parasite", 2024, 8.5), new Movie("Joker", 2021, 7.2), new Movie("Inception", 2020, 8.9),
				new Movie("Interstellar", 2024, 9.2));

		movies.stream().filter(m -> m.rating >= 7.0) //filter by rating
				.sorted((a, b) -> { //sort by rating and year
					if (a.rating == b.rating)
						return b.year - a.year;
					return Double.compare(b.rating, a.rating);
				}).limit(5) // top 5
				.forEach(m -> System.out.println(m.name + " " + m.year + " " + m.rating));
	}
}
