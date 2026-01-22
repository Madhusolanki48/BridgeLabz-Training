package list_interface;
import java.util.*;

public class FrequencyOfElements {
	public static Map<String, Integer> findFrequency(List<String> list){
		Map<String, Integer> freqMap = new HashMap<>();

        for (String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        //print output
        System.out.println("Input List: " + list);
        System.out.println("Frequency Map: " + findFrequency(list));
    }

}
