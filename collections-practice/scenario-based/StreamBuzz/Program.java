package StreamBuzz;
import java.util.*;

public class Program {
	public void registerCreator(CreatorStats record) {
		if(record!=null)
		CreatorStats.engagementBoard.add(record);
	}
	public Map<String,Integer> getTopPostCounts(List<CreatorStats> records,double likeThreshhold){
		Map<String,Integer> result=new HashMap<>();
		for(CreatorStats record:records) {
			int count=0;
			for(double likes:record.getWeeklyLikes()) {
				if(likes>=likeThreshhold) {
					count++;
				}
			}
			if(count>0)
			result.put(record.getCreatorName(),count);
		}
		return result;
		
	}
	//method to calculate average likes
	public double calculateAverageLikes() {
		List<Double> allLikes=new ArrayList<>();
        for (CreatorStats creator:CreatorStats.engagementBoard) {
            for (double likes:creator.getWeeklyLikes()) {
                allLikes.add(likes);
            }
        }
        if (allLikes.isEmpty()) return 0;
        double sum=0;
        for (double likes:allLikes) 
        	sum += likes;
        return sum/allLikes.size();
	}
}
