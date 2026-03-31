package SmartUniversityLibraryManagementSystem;
import java.util.*;
public class LibraryCatalog {
	private static volatile LibraryCatalog instance;

	private final List<Book> books = new ArrayList<>();
	private final List<LibraryObserver> generalObservers = new ArrayList<>();
	private final Map<String, List<LibraryObserver>> waitlist = new HashMap<>();

	private LibraryCatalog() {
	}

	public static LibraryCatalog getInstance() {
		if (instance == null) {
			synchronized (LibraryCatalog.class) {
				if (instance == null) {
					instance = new LibraryCatalog();
				}
			}
		}
		return instance;
	}

	public void addBook(Book book) {
		books.add(book);
		String title = book.getTitle();

		// General new arrival notification
		String msg = "New book added: " + title;
		notifyObservers(msg);

		// Specific waitlist notification
		if (waitlist.containsKey(title)) {
			String availMsg = "Book now available: " + title;
			for (LibraryObserver obs : new ArrayList<>(waitlist.get(title))) {
				obs.update(availMsg);
			}
			waitlist.remove(title); // clear waitlist after notification
		}
	}

	public void registerObserver(LibraryObserver obs) {
		if (!generalObservers.contains(obs))
			generalObservers.add(obs);
	}

	public void unregisterObserver(LibraryObserver obs) {
		generalObservers.remove(obs);
	}

	public void subscribeToBook(String title, LibraryObserver obs) {
		waitlist.computeIfAbsent(title, k -> new ArrayList<>()).add(obs);
		System.out.println(obs + " subscribed to notifications for: " + title);
	}

	private void notifyObservers(String message) {
		for (LibraryObserver obs : new ArrayList<>(generalObservers)) {
			obs.update(message);
		}
	}

	public List<Book> getBooks() {
		return Collections.unmodifiableList(books);
	}
}
