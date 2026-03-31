package EventFeedbackNRatingAnalyzer;

public class EventFeedbackMain {

    public static void main(String[] args) {

        FeedbackAnalyzerService analyzer = new FeedbackAnalyzerService();

        try {
            analyzer.addRating("Event1", 5);
            analyzer.addRating("Event1", 4);
            analyzer.addRating("Event2", 3);
            analyzer.addRating("Event2", 5);

            System.out.println("----------  Event Feedback Summary  ---------");

            String topEvent = analyzer.getTopEvent();
            System.out.println("Top Rated Event : " + topEvent);

            System.out.printf("Average Rating (%s) : %.2f%n",
                    topEvent, analyzer.getAverage(topEvent));

        } catch (InvalidRatingException e) {
            System.out.println(e.getMessage());
        }
    }
}
