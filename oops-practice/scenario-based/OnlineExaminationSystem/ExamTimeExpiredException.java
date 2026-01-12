package OnlineExaminationSystem;

//custom exception
public class ExamTimeExpiredException extends Exception {
	public ExamTimeExpiredException(String message) {
		super(message);
	}
}
