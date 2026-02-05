package collectors;
import java.util.*;
import java.util.stream.*;

class Book {
	String genre;
	int pages;
    //constructor
	Book(String genre, int pages) {
		this.genre = genre;
		this.pages = pages;
	}
    //getter method
	String getGenre() {
		return genre;
	}

	int getPages() {
		return pages;
	}
}
//main class
public class LibraryBookStatistics {
	public static void main(String[] args) {

		List<Book> books = List.of(new Book("Fiction", 300), new Book("Fiction", 500), new Book("Science", 400));

		//group by genre and collect page statistics
		Map<String, IntSummaryStatistics> stats = books.stream()
				.collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)));

		//print values
		stats.forEach((genre, s) -> {
			System.out.println("Genre: " + genre);
			System.out.println("Total Pages   : " + s.getSum());
			System.out.println("Average Pages : " + s.getAverage());
			System.out.println("Max Pages     : " + s.getMax());
			System.out.println();
		});
	}
}
