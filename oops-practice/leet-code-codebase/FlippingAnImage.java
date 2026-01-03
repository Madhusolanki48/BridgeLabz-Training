package leet_code_codebase;
import java.util.Scanner;
//Leetcode Problem : 832
//Given a binary matrix, first flip each row horizontally(reverse the row), then invert each bit (0→1, 1→0).

public class FlippingAnImage{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();
        int[][] img = new int[r][c];

        System.out.println("Enter matrix values (0 or 1):");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                img[i][j] = sc.nextInt();
            }
        }
        //method call
        int[][] result = flipAndInvertImage(img);
        System.out.println("Result matrix:");
        for (int[] row : result) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }

    }
    //method to flip and invert image
    public static int[][] flipAndInvertImage(int[][] img) {
        for (int i = 0; i < img.length; i++) {

            //iterate only half because we swap while inverting
            for (int j = 0; j < (img[i].length + 1) / 2; j++) {
                //XOR with 1, inverts bit
                int temp = img[i][j] ^ 1;
                //swap element from opposite side and invert it
                img[i][j] = img[i][img[i].length - j - 1] ^ 1;
                //assign stored inverted value to opposite side
                img[i][img[i].length - j - 1] = temp;
            }
        }

        return img;
    }
}

