package list_interface;
import java.util.*;
public class RotateElements {
	public static List<Integer> rotateLeft(List<Integer> list, int k) {
		int n = list.size();
		k = k % n; //handle if k > size

		List<Integer> rotated = new ArrayList<>();

		//add elements from k to end
		for (int i = k; i < n; i++) {
			rotated.add(list.get(i));
		}

		//add first k elements
		for (int i = 0; i < k; i++) {
			rotated.add(list.get(i));
		}

		return rotated;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
		int k = 2;
        //print output
		System.out.println("Original List: " + list);
		System.out.println("Rotated List: " + rotateLeft(list, k));
	}

}
