package methods;
import java.util.Scanner;
public class MatrixManipulationOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of rows : ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns : ");
        int cols = sc.nextInt();
        
        int[][] A = generateRandomMatrix(rows, cols);
        int[][] B = generateRandomMatrix(rows, cols);
        System.out.println("Random generated Matrix A");
        printMatrix(A);
        System.out.println("Random generated Matrix B");
        printMatrix(B);
        //Addition
        int[][] add = addMatrices(A, B);
        System.out.println("\nMatrix Addition (A + B)");
        printMatrix(add);
        //Subtraction
        int[][] sub = subtractMatrices(A, B);
        System.out.println("\nMatrix Subtraction (A - B)");
        printMatrix(sub);
        //Multiplication (only if valid)
        if (A[0].length == B.length) {
            int[][] mul = multiplyMatrices(A, B);
            System.out.println("\nMatrix Multiplication (A × B)");
            printMatrix(mul);
        } else {
            System.out.println("\nMatrix Multiplication Not Possible (Invalid Dimensions)");
        }
    }
    //method to create random matrix
    public static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = (int)(Math.random() * 10); 
            }
        }
        return m;
    }
    //method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }
    //method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int c2 = B[0].length;

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {

                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    sum += A[i][k] * B[k][j];
                }

                result[i][j] = sum;
            }
        }
        return result;
    }
    //utility method to print matrix
    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}
