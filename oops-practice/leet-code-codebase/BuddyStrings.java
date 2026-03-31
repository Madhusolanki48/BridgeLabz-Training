package leet_code_codebase;
import java.util.*;

public class BuddyStrings {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first string: ");
        String s = sc.nextLine();
        System.out.print("Enter second string: ");
        String goal = sc.nextLine();
        //method calling
        boolean result = buddyStrings(s, goal);
        if (result)
            System.out.println("Buddy Strings");
        else
            System.out.println("Not Buddy Strings");
    }
    //method to check if two strings are buddy strings
    public static boolean buddyStrings(String s, String goal) {
        //both strings must have equal length
        if (s.length() != goal.length())
            return false;
        //when both strings differ at exactly two positions
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        //exactly two indices differ,swap check
        if (diff.size() == 2) {

            int i1 = diff.get(0);
            int i2 = diff.get(1);

            return (s.charAt(i1) == goal.charAt(i2) &&
                    s.charAt(i2) == goal.charAt(i1));
        }
        //strings are already equal
        // buddy condition holds only if any char appears twice
        if (diff.size() == 0) {
            Set<Character> set = new HashSet<>();
            for (char ch : s.toCharArray()) {
                if (!set.add(ch)) {
                    return true;   // duplicate found
                }
            }
            return false;
        }
        return false;
    }
}

