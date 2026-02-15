package EventFeedbackNRatingAnalyzer;

//custom exception thrown when rating is outside 1–5
public class InvalidRatingException extends Exception {

    public InvalidRatingException(String message) {
        super(message);
    }
}
