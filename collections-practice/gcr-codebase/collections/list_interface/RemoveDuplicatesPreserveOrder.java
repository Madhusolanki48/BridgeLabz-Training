package list_interface;
import java.util.*;

public class RemoveDuplicatesPreserveOrder {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        //print output
        System.out.println("Original List: " + list);
        System.out.println("After Removing Duplicates: " + removeDuplicates(list));
    }
}

