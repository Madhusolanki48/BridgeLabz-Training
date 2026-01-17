package linear_binary_search;
import java.util.*;
//Linear Search Problem 2: Search for a Specific Word in a List of Sentences

public class SearchWordInSentences {
    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Sentences: ");
        int n = Integer.parseInt(sc.nextLine());

        //sentences input
        String[] sentences = new String[n];
        System.out.println("Enter Sentences:");
        for (int i = 0; i < n; i++) sentences[i] = sc.nextLine();

        System.out.print("Enter Word to Search: ");
        String word = sc.nextLine();

        String result = "Not Found";
        for (String s : sentences) {
            if (s.contains(word)) { //word found
                result = s;
                break;
            }
        }

        System.out.println("Result: " + result);
    }
}
