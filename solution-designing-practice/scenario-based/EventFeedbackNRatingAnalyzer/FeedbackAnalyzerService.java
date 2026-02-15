package EventFeedbackNRatingAnalyzer;
import java.util.*;

//processes event feedback
public class FeedbackAnalyzerService {

	private Map<String, List<Integer>> feedbackMap = new HashMap<>();

	// Add rating for an event
	public void addRating(String eventId, int rating) throws InvalidRatingException {

		if (rating < 1 || rating > 5) {
			throw new InvalidRatingException("Rating must be between 1 and 5");
		}

		feedbackMap.computeIfAbsent(eventId, k -> new ArrayList<>()).add(rating);
	}

	// Calculate average rating
	public double getAverage(String eventId) {
		List<Integer> ratings = feedbackMap.get(eventId);
		if (ratings == null || ratings.isEmpty())
			return 0;

		int sum = 0;
		for (int r : ratings)
			sum += r;

		return (double) sum / ratings.size();
	}

	// Find top-rated event
	public String getTopEvent() {

		String topEvent = null;
		double maxAvg = 0;

		for (String eventId : feedbackMap.keySet()) {
			double avg = getAverage(eventId);
			if (avg > maxAvg) {
				maxAvg = avg;
				topEvent = eventId;
			}
		}
		return topEvent;
	}
}
