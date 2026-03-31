package OnlineExaminationSystem;

//objective question class
public class ObjectiveQuestion extends Question {
	//attribute
	private String correctAnswer;

	//constructor
	public ObjectiveQuestion(int questionId, String questionText, String correctAnswer) {
		super(questionId, questionText);
		this.correctAnswer = correctAnswer;
	}

	//getter
	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
