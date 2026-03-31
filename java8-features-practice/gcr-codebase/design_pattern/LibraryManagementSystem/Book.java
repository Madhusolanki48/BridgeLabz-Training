package LibraryManagementSystem;
//book entity using Builder pattern
public class Book {
	private final String title; 
	private final String author; 
	private final String edition; 
	private final String genre; 

	private Book(BookBuilder builder) {
		this.title = builder.title;
		this.author = builder.author;
		this.edition = builder.edition;
		this.genre = builder.genre;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("“").append(title).append("”");
		if (author != null)
			sb.append(" by ").append(author);
		if (edition != null)
			sb.append(", ").append(edition).append(" ed.");
		if (genre != null)
			sb.append(" [").append(genre).append("]");
		return sb.toString();
	}

	//builder
	public static class BookBuilder {
		private final String title;
		private String author;
		private String edition;
		private String genre;

		public BookBuilder(String title) {
			if (title == null || title.trim().isEmpty()) {
				throw new IllegalArgumentException("Title is mandatory");
			}
			this.title = title.trim();
		}

		public BookBuilder author(String author) {
			this.author = author;
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

		public Book build() {
			return new Book(this);
		}
	}
}