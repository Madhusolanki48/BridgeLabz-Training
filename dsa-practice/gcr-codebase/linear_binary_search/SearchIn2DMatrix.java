package linear_binary_search;
import java.util.*;
//Binary Search Problem 3: Search for a Target Value in a 2D Sorted Matrix

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter Number of Columns: ");
        int numColumns = sc.nextInt();

        //matrix input
        int[][] matrix = new int[rows][numColumns];
        System.out.println("Enter Matrix Elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < numColumns; j++)
                matrix[i][j] = sc.nextInt();

        System.out.print("Enter Target: ");
        int target = sc.nextInt();
        int left = 0;
        int right = rows * numColumns - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            int row = mid / numColumns;   // row index
            int col = mid % numColumns;   // col index

            if (matrix[row][col] == target) {
                found = true; 
                break;
            } else if (matrix[row][col] < target) {
                left = mid + 1; // go right
            } else {
                right = mid - 1; // go left
            }
        }

        System.out.println("Target exists in the given 2D Matrix? : "+found);
    }

	
}

