package sorting_algorithms;
import java.util.Arrays;
//Selection Sort - Sort Exam Scores

public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            //swap
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {56, 89, 34, 75, 92};
        System.out.println("----------------  Selection Sort  --------------");
        System.out.println("Exam ScoresBefore Sorting: " + Arrays.toString(examScores));

        selectionSort(examScores);

        System.out.println("Exam Scores After Sorting:  " + Arrays.toString(examScores));
    }
}
