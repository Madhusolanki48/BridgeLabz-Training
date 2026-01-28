package FileBackupScheduler;

//custom exception for invalid path
public class InvalidBackupPathException extends Exception {
	public InvalidBackupPathException(String message) {
		super(message);
	}
}
