package leet_code_codebase;
import java.util.Scanner;
public class IndexOfFirstOccurance {
    // LeetCode-28
    // Find the starting index of one string inside another string, return -1 if not found.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //take user input
        System.out.print("Enter the main string: ");
        String mainString = sc.nextLine();
        System.out.print("Enter the string to search: ");
        String stringToBeSearch = sc.nextLine();
        //method calling
        int result = findIndex(mainString, stringToBeSearch);
        //print output
        if (result != -1) {
            System.out.println("String found at index: " + result);
        } else {
            System.out.println("String not found");
        }
    }
    // method to find index
    static int findIndex(String mainString, String stringToBeSearch) {
        if (stringToBeSearch.length() > mainString.length()) { //edge case
            return -1;
        }
        int count = 0;   // matched characters count
        int index = 0;   // starting index
        for (int i = 0, j = 0; i < mainString.length(); i++) {
            if (mainString.charAt(i) == stringToBeSearch.charAt(j)) {
                if (count == 0) {
                    index = i;
                }
                count++;
                j++;
                if (count == stringToBeSearch.length()) {
                    return index;
                }
            } else {
                i = i - count;  // reset i to next possible position
                count = 0;
                j = 0;
            }
        }
        return -1;
    }
}
