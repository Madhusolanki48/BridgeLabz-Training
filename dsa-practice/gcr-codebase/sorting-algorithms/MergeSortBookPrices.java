package sorting_algorithms;
import java.util.Arrays;
//Merge Sort - Sort an Array of Book Prices

public class MergeSortBookPrices {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left >= right)
        	return;
        int mid = left + (right - left) / 2;
        mergeSort(prices, left, mid);
        mergeSort(prices, mid + 1, right);

        merge(prices, left, mid, right);
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;    //number of elements in the left half
        int n2 = right - mid;       //number of elements in the right half

        int[] leftElements = new int[n1];
        int[] rightElements = new int[n2];

        for (int i = 0; i < n1; i++)
        	leftElements[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
        	rightElements[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftElements[i] <= rightElements[j])
            	prices[k++] = leftElements[i++];
            else prices[k++] = rightElements[j++];
        }

        while (i < n1)
        	prices[k++] = leftElements[i++];
        while (j < n2)
        	prices[k++] = rightElements[j++];
    }

    public static void main(String[] args) {
        int[] bookPrices = {499, 299, 799, 199, 650, 120};
        System.out.println("----------------------  Merge Sort  ----------------------");
        System.out.println("Book Prices Before Sorting: " + Arrays.toString(bookPrices));

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Book Prices After Sorting:  " + Arrays.toString(bookPrices));
    }
}

