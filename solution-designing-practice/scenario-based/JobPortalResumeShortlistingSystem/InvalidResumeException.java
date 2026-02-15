package JobPortalResumeShortlistingSystem;

//custom exception thrown when resume data is invalid
public class InvalidResumeException extends Exception {

    public InvalidResumeException(String message) {
        super(message);
    }
}
