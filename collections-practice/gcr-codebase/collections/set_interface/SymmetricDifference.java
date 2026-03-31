package set_interface;
import java.util.*;

public class SymmetricDifference {  //elements present in either set but not in both of two sets
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); //union

        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2); //intersection

        result.removeAll(common); //remove common

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + result);
    }
}

