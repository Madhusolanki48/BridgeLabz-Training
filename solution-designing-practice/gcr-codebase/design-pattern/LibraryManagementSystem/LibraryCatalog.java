package LibraryManagementSystem;
import java.util.*;
public class LibraryCatalog {
    private static volatile LibraryCatalog instance;
    private final List<Book> books = new ArrayList<>();
    private final List<LibraryObserver> observers = new ArrayList<>();

    private LibraryCatalog() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Use getInstance() to get the single instance");
        }
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
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        books.add(book);
        notifyObservers("New book available: " + book.getTitle());
    }

    public void addObserver(LibraryObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (LibraryObserver observer : new ArrayList<>(observers)) {  // avoid CME
            observer.update(message);
        }
    }

    // For demo / debugging
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // defensive copy
    }
}
