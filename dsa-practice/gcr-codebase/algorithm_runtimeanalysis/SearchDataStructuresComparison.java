package algorithm_runtimeanalysis;
import java.util.*;
public class SearchDataStructuresComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dataset size (N): ");
        int n = sc.nextInt();
        //prepare data
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        //choose a target to search
        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();
        //array search using linear search
        long startTime = System.nanoTime();
        boolean arrayFound = linearSearch(array, target);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Array search found: " + arrayFound + " | Time: " + arrayTime + " ms");
        //hashSet search
        startTime = System.nanoTime();
        boolean hashSetFound = hashSet.contains(target);
        endTime = System.nanoTime();
        double hashSetTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("HashSet search found: " + hashSetFound + " | Time: " + hashSetTime + " ms");
        //treeSet search
        startTime = System.nanoTime();
        boolean treeSetFound = treeSet.contains(target);
        endTime = System.nanoTime();
        double treeSetTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("TreeSet search found: " + treeSetFound + " | Time: " + treeSetTime + " ms");

    }
    //linear search for array
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
