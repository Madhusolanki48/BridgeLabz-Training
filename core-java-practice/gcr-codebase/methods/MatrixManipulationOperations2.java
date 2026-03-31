package methods;
import java.util.Scanner;
public class MatrixManipulationOperations2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter rows : ");
        int rows = sc.nextInt();
        System.out.print("Enter columns : ");
        int cols = sc.nextInt();
        double[][] M = createRandomMatrix(rows, cols);
        System.out.println("\nMatrix M");
        displayMatrix(M);
        double[][] T = transposeMatrix(M);
        System.out.println("\nTranspose of Matrix M ");
        displayMatrix(T);
        // Determinant / Inverse only for square matrices
        if (rows == cols) {
            if (rows == 2) {
                //Determinant of 2x2
                double det2 = determinant2x2(M);
                System.out.println("\nDeterminant of 2x2 Matrix = " + det2);
                //Inverse of 2x2
                if (det2 != 0) {
                    System.out.println("\nInverse of 2x2 Matrix");
                    double[][] inv2 = inverse2x2(M);
                    displayMatrix(inv2);
                } else {
                    System.out.println("\nInverse does not exist (Determinant = 0)");
                }
            }
            if (rows == 3) {
                //Determinant of 3x3
                double det3 = determinant3x3(M);
                System.out.println("\nDeterminant of 3x3 Matrix = " + det3);
                //Inverse of 3x3
                if (det3 != 0) {
                    System.out.println("\nInverse of 3x3 Matrix");
                    double[][] inv3 = inverse3x3(M);
                    displayMatrix(inv3);
                } else {
                    System.out.println("\nInverse does not exist (Determinant = 0)");
                }
            }

        } else {
            System.out.println("\nDeterminant and Inverse not applicable (Not a square matrix)");
        }
    }
    //method to create random matrix
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] m = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = (int)(Math.random() * 10); 
            }
        }
        return m;
    }
    //method to find transpose
    public static double[][] transposeMatrix(double[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        double[][] t = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }
    //method to find determinant of 2x2 matrix
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    //method to find determinant of 3x3 matrix
    public static double determinant3x3(double[][] m) {
        return
                m[0][0] * ((m[1][1] * m[2][2]) - (m[1][2] * m[2][1])) -
                m[0][1] * ((m[1][0] * m[2][2]) - (m[1][2] * m[2][0])) +
                m[0][2] * ((m[1][0] * m[2][1]) - (m[1][1] * m[2][0]));
    }
    //method to find inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        double[][] inverse = new double[2][2];
        inverse[0][0] =  m[1][1] / det;
        inverse[0][1] = -m[0][1] / det;
        inverse[1][0] = -m[1][0] / det;
        inverse[1][1] =  m[0][0] / det;
        return inverse;
    }
    //method to find inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {

        double det = determinant3x3(m);
        double[][] inverse = new double[3][3];

        inverse[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inverse[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inverse[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inverse[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inverse[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inverse[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inverse[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inverse[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inverse[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inverse;
    }
    //method to display a matrix
    public static void displayMatrix(double[][] m) {
        for (double[] row : m) {
            for (double value : row) {
                System.out.printf("%6.2f", value);
            }
            System.out.println();
        }
    }
}
