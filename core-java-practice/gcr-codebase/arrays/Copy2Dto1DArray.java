package arrays;
import java.util.Scanner;
public class Copy2Dto1DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //matrix size
        System.out.print("Enter the number of rows of 2-D Array : ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns of 2-D Array : ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        //2D array input from the user
        System.out.print("Enter the elements in the rows of 2-D Array : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //create 1D array
        int[] array = new int[rows * cols];
        int index = 0;
        //converting 2D to 1D Array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }
        //print 1D array
        System.out.print("Conversion of 2-D array to 1-D array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
