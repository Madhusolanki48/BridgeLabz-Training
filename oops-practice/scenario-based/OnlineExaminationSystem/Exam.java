package OnlineExaminationSystem;
import java.util.ArrayList;

//exam class
public class Exam {
	//attributes
	private int examId;
	private String title;
	private int durationMinutes;
	private ArrayList<Question> questions;

	//constructor
	public Exam(int examId, String title, int durationMinutes) {
		this.examId = examId;
		this.title = title;
		this.durationMinutes = durationMinutes;
		this.questions = new ArrayList<>();
	}

	//getters
	public int getId() {
		return examId;
	}

	public String getTitle() {
		return title;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	//method to add question
	public void addQuestion(Question question) {
		questions.add(question);
	}

	//method to check exam time
	public void checkExamTime(int timeTaken) throws ExamTimeExpiredException {
		if (timeTaken > durationMinutes) {
			throw new ExamTimeExpiredException("Exam time expired! You took " + timeTaken + " minutes.");
		}
	}

	//method to calculate total marks
	public int getTotalMarks() {
		return questions.size();
	}

	@Override
	public String toString() {
		return "Exam Details: " + "Id - " + examId + " | Title - " + title + " | Duration - " + durationMinutes
				+ " mins | Questions - " + questions.size();
	}
}
