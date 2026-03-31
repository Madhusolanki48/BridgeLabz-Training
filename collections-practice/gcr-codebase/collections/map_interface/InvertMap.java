package map_interface;
import java.util.*;

public class InvertMap {
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            inverted.putIfAbsent(value, new ArrayList<>());
            inverted.get(value).add(key);
        }

        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        //print output
        System.out.println("Original Map: " + map);
        System.out.println("Inverted Map: " + invertMap(map));
    }
}
