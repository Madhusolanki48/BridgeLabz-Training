package linkedlist;
//Using Doubly LinkedList
class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class Node {
    Movie data;
    Node next;
    Node prev;

    Node(Movie data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagementSystem {
    static Node head = null;
    static Node tail = null;

    //add a movie record at the beginning
    static void insertAtBeginning(Movie movie) {
        Node newNode = new Node(movie);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //add a movie record at end
    static void insertAtEnd(Movie movie) {
        Node newNode = new Node(movie);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //add a movie record at specific position
    static void insertAtPosition(Movie movie, int position) {
        if (position <= 1 || head == null) {
            insertAtBeginning(movie);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            insertAtEnd(movie);
            return;
        }

        Node newNode = new Node(movie);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    //method to remove a movie record by movie title.
    static void deleteByTitle(String title) {
        if (head == null) {
            System.out.println("No movies available");
            return;
        }

        Node temp = head;

        while (temp != null && !temp.data.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie deleted successfully");
    }

    //method to search for a movie record by director or rating
    static void searchByDirector(String director) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found for this director");
    }

    //method to search for a movie record by rating
    static void searchByRating(double rating) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found with this rating");
    }

    //method to update a movie's rating based on the movie title.
    static void updateRating(String title, double newRating) {
        Node temp = head;

        while (temp != null && !temp.data.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.data.rating = newRating;
            System.out.println("Rating updated successfully");
        } else {
            System.out.println("Movie not found");
        }
    }

    //method to display all movie records in both forward and reverse order
    static void displayForward() {
        Node temp = head;
        System.out.println("------ Movies : Forward ------");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    static void displayReverse() {
        Node temp = tail;
        System.out.println("------ Movies : Reverse ------");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    static void displayMovie(Node node) {
        System.out.println("Title     : " + node.data.title);
        System.out.println("Director  : " + node.data.director);
        System.out.println("Year      : " + node.data.year);
        System.out.println("Rating    : " + node.data.rating);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        Movie movie1 = new Movie("Inception", "Christopher Nolan", 2010, 9.0);
        Movie movie2 = new Movie("Interstellar", "Christopher Nolan", 2014, 8.6);
        Movie movie3 = new Movie("Avatar", "James Cameron", 2009, 7.8);
        Movie movie4 = new Movie("Titanic", "James Cameron", 1997, 9.1);
        //insert node
        insertAtEnd(movie1);
        insertAtEnd(movie2);
        insertAtBeginning(movie3);
        insertAtPosition(movie4, 2);
        //display 
        displayForward();
        displayReverse();
        //search
        searchByDirector("James Cameron");
        searchByRating(9.0);
        //update
        updateRating("Avatar", 8.2);
        displayForward();
        //delete
        deleteByTitle("Titanic");
        displayForward();
    }
}
