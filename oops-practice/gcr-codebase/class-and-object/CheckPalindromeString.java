package class_and_object;

// Class to check whether a string is palindrome
class PalindromeChecker {
    private String text;   //attribute  
    //constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    //method to check if the text is a palindrome
    public boolean isPalindrome() {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        return new StringBuilder(clean).reverse().toString().equals(clean);
    }

    //method to display result
    public void display() {
        if (isPalindrome())
            System.out.println(text + " is palindrome");
        else
            System.out.println(text + " is not Palindrome");
    }
}

public class CheckPalindromeString {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker p2 = new PalindromeChecker("Hello");
        p1.display();
        p2.display();
    }
}
