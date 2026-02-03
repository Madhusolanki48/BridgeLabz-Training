package StreamBuzz;
import java.util.*;
public class CreatorStats {
	//attributes
	private String CreatorName;
	private List<Double> weeklyLikes;
	public static List<CreatorStats> engagementBoard=new ArrayList<>();
	//constructor
	public CreatorStats(String CreatorName,List<Double> weeklyLikes) {
		this.CreatorName=CreatorName;
		this.weeklyLikes=weeklyLikes;
	}
	//getter method
	public String getCreatorName() {
	    return CreatorName;
	}

	public List<Double> getWeeklyLikes() {
	     return weeklyLikes;
	}
}
