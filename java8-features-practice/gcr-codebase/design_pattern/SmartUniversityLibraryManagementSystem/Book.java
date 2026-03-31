package SmartUniversityLibraryManagementSystem;
import java.util.*;
public class Book {
	private final String title;
	private final List<String> authors;
	private final String edition;
	private final String genre;
	private final String publisher;
	private final String isbn;

	private Book(BookBuilder builder) {
		this.title = builder.title;
		this.authors = builder.authors != null ? List.copyOf(builder.authors) : List.of();
		this.edition = builder.edition;
		this.genre = builder.genre;
		this.publisher = builder.publisher;
		this.isbn = builder.isbn;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("“" + title + "”");
		if (!authors.isEmpty())
			sb.append(" by ").append(String.join(", ", authors));
		if (edition != null)
			sb.append(", ").append(edition).append(" ed.");
		if (genre != null)
			sb.append(" [").append(genre).append("]");
		if (publisher != null)
			sb.append(" – ").append(publisher);
		if (isbn != null)
			sb.append(" (ISBN: ").append(isbn).append(")");
		return sb.toString();
	}

	public static class BookBuilder {
		private final String title;
		private List<String> authors;
		private String edition, genre, publisher, isbn;

		public BookBuilder(String title) {
			if (title == null || title.trim().isEmpty())
				throw new IllegalArgumentException("Title is required");
			this.title = title.trim();
		}

		public BookBuilder authors(String... authors) {
			this.authors = Arrays.asList(authors);
			return this;
		}

		public BookBuilder edition(String edition) {
			this.edition = edition;
			return this;
		}

		public BookBuilder genre(String genre) {
			this.genre = genre;
			return this;
		}

		public BookBuilder publisher(String p) {
			this.publisher = p;
			return this;
		}

		public BookBuilder isbn(String isbn) {
			this.isbn = isbn;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}
}
