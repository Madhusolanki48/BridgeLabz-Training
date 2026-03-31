package OnlineExaminationSystem;

//descriptive question class
public class DescriptiveQuestion extends Question {
	//attribute
	private String modelAnswer;

	//constructor
	public DescriptiveQuestion(int questionId, String questionText, String modelAnswer) {
		super(questionId, questionText);
		this.modelAnswer = modelAnswer;
	}

	//getter
	public String getModelAnswer() {
		return modelAnswer;
	}
}
