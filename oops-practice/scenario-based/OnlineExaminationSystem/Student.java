package OnlineExaminationSystem;
import java.util.ArrayList;

//student class
public class Student {
	//attributes
	private int studentId;
	private String name;
	private ArrayList<Answer> answerList;

	//constructor
	public Student(int studentId, String name) {
		this.studentId = studentId;
		this.name = name;
		this.answerList = new ArrayList<>();
	}

	//getters
	public int getId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}

	//method to submit answer
	public void submitAnswer(int examId, int questionId, String response) {
		answerList.add(new Answer(examId, questionId, response));
	}

	//method to get answer by question
	public String getAnswer(int examId, int questionId) {
		for (Answer a : answerList) {
			if (a.getExamId() == examId && a.getQuestionId() == questionId) {
				return a.getResponse();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Student Details: " + "Id - " + studentId + " | Name - " + name;
	}
}
