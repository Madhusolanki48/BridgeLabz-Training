package sorting_algorithms;
import java.util.Arrays;
//Quick Sort - Sort Product Prices

public class QuickSortProductPrices {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex= partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];  //pivot = last element
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
    	System.out.println("------------------------  Quick Sort  ------------------------");
        int[] productPrices = {998, 197, 499, 1299, 250, 799};
        System.out.println("Product Prices Before Sorting: " + Arrays.toString(productPrices));
        
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Product Prices After Sorting:  " + Arrays.toString(productPrices));
    }
}
