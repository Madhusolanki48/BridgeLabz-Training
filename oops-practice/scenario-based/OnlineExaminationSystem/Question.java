package OnlineExaminationSystem;

//question class
public abstract class Question {
	//attributes
	private int questionId;
	private String questionText;

	//constructor
	public Question(int questionId, String questionText) {
		this.questionId = questionId;
		this.questionText = questionText;
	}

	//getters
	public int getQuestionId() {
		return questionId;
	}

	public String getQuestionText() {
		return questionText;
	}
}
