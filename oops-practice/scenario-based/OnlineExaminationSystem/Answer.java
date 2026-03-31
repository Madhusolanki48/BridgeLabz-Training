package OnlineExaminationSystem;

//answer class
public class Answer {
	//attributes
	private int examId;
	private int questionId;
	private String response;

	//constructor
	public Answer(int examId, int questionId, String response) {
		this.examId = examId;
		this.questionId = questionId;
		this.response = response;
	}

	//getters
	public int getExamId() {
		return examId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public String getResponse() {
		return response;
	}
}
