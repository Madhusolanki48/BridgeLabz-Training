package Review3;
import java.util.*;
import java.util.stream.*;

public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = sc.next();
		Character firstNonRepeatingChar = str.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.map(e -> e.getKey())
				.findFirst()
				.orElse(null);
		System.out.println("The First Non-Repeating Character in the given String: "+firstNonRepeatingChar);
	}

}
