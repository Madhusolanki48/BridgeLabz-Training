package leet_code_codebase;
import java.util.Scanner;
//Leetcode problem: 1417
//Reformat a string so that letters and digits appear alternately.Return empty string if not possible.
public class ReformatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string: ");
        String string = sc.nextLine();
        String result = reformat(string);
        System.out.println("Reformatted string: " + result);
    }
    public static String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        //separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                digits.append(c);
            else
                letters.append(c);
        }

        //if difference greater than 1 → not possible
        if (Math.abs(letters.length() - digits.length()) > 1)
            return "";

        //decide which type starts first
        StringBuilder first = letters.length() >= digits.length() ? letters : digits;
        StringBuilder second = first == letters ? digits : letters;
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < first.length() || i < second.length()) {
            if (i < first.length())
                result.append(first.charAt(i));
            if (i < second.length())
                result.append(second.charAt(i));
            i++;
        }
        return result.toString();
    }
}

