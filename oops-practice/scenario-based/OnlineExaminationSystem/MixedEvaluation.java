package OnlineExaminationSystem;

//polymorphism based evaluation for objective + descriptive
public class MixedEvaluation implements EvaluationStrategy {
	public double evaluate(Exam exam, Student student) {
		double score = 0;
		for (Question question : exam.getQuestions()) {

			//objective evaluation
			if (question instanceof ObjectiveQuestion) {
				ObjectiveQuestion objectiveQuestion = (ObjectiveQuestion) question;
				String studentAns = student.getAnswer(exam.getId(), question.getQuestionId());

				if (studentAns != null && studentAns.equalsIgnoreCase(objectiveQuestion.getCorrectAnswer())) {
					score += 1;
				}
			}

			//descriptive evaluation
			else if (question instanceof DescriptiveQuestion) {
				DescriptiveQuestion descriptiveQuestion = (DescriptiveQuestion) question;
				String studentAns = student.getAnswer(exam.getId(), question.getQuestionId());

				if (studentAns != null && studentAns.length() >= 5) {
					score += 1;
				}
			}
		}
		return score;
	}
}
