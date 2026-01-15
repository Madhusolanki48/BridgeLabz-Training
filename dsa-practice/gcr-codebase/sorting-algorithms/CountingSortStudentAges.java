package sorting_algorithms;
import java.util.Arrays;
//Counting Sort - Sort Student Ages

public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
    	//given: ages ranging from 10 to 18
        int min = 10;
        int max = 18;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];
        //frequency count
        for (int age : ages) {
            count[age - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 14, 18};
        System.out.println("-------------------  Counting Sort  -----------------");
        System.out.println("Age of Students Before Sorting: " + Arrays.toString(studentAges));
        
        countingSort(studentAges);
        System.out.println("Age of Students After Sorting:  " + Arrays.toString(studentAges));
    }
}



