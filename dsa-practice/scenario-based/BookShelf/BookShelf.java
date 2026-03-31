package BookShelf;
import java.util.*;

class BookShelf {  //storing the list of books
    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();
    private HashSet<Book> uniqueBooks = new HashSet<>();

    //method to add book
    public boolean addBook(String genre, Book book) {
        if (uniqueBooks.contains(book)) {
            return false;
        }

        genre = genre.toLowerCase();
        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        uniqueBooks.add(book);

        return true;
    }


    //method to borrow book 
    public void borrowBook(String genre, String title) {
        genre = genre.toLowerCase();

        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found!");
            return;
        }

        LinkedList<Book> list = catalog.get(genre);

        Iterator<Book> it = list.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book.title.equalsIgnoreCase(title)) {
                it.remove();
                uniqueBooks.remove(book);
                System.out.println("Book borrowed: " + book);
                return;
            }
        }

        System.out.println("Book not found!");
    }

    //method to return book
    public boolean returnBook(String genre, Book book) {
        return addBook(genre, book);
    }

    //method to display catalog
    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog empty!");
            return;
        }

        System.out.println("\n-------  Genre Wise Library Catalog  --------");
        for (String genre : catalog.keySet()) {
            System.out.println("\nGenre: " + genre.toUpperCase());
            for (Book b : catalog.get(genre)) {
                System.out.println(" - " + b);
            }
        }
    }
}
