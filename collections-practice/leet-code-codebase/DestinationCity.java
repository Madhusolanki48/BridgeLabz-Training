package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1436
// Find the destination city from given paths.

public class DestinationCity {
	//method to find destination city
    public static String destinationCity(List<List<String>> paths) {

        Map<String, String> map = new HashMap<>();

        //store source -> destination
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        //destination city will not be a source
        for (String city : map.values()) {
            if (!map.containsKey(city)) {
                return city;
            }
        }

        return "";
    }
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London", "NewYork"));
        paths.add(Arrays.asList("NewYork", "Lima"));
        paths.add(Arrays.asList("Lima", "SaoPaulo"));
        //method calling
        String result = destinationCity(paths);
        //print output
        System.out.println("Destination City: " + result);
    }
}
