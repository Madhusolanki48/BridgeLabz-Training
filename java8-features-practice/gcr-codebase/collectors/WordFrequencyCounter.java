package collectors;
import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String text = "java is programming is a java language";

		//split text into words
		String[] words = text.split(" ");

		//count word frequency
		Map<String, Integer> wordCount = Arrays.stream(words).collect(Collectors.toMap(
				word -> word, //key
				word -> 1,   //initial count
				Integer::sum //merge if duplicate
		));

		System.out.println(wordCount);
	}
}
