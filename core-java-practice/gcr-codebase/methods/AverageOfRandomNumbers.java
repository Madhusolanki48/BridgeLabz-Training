package methods;
import java.util.Arrays;
public class AverageOfRandomNumbers {
	public static void main(String[] args) {
        //generate 5 random values
        int[] randomNumbers = generate4DigitRandomArray(5);
        //method call
        double[] result = findAverageMinMaxNumber(randomNumbers);
        //print output
        System.out.println("Generated Numbers: " + Arrays.toString(randomNumbers));
        System.out.println("Average of the numbers = " + result[0]);
        System.out.println("Minimum number = " + result[1]);
        System.out.println("Maximum number = " + result[2]);
    }

    //method to generate 4-digit random array
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            //random 4-digit number between 1000 and 9999
            numbers[i] = (int)(1000 + Math.random() * 9000);
        }
        return numbers;
    }

    //method to find Average of the numbers, Minimum number, Max number
    public static double[] findAverageMinMaxNumber(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }
}

