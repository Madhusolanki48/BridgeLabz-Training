package scenario_based;
import java.util.*;

public class LexicalTwist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//user input
		System.out.print("Enter the first word: ");
		String word1 = sc.nextLine();
		//validation for first word
		if (word1.trim().contains(" ")) {
			System.out.println(word1 + " is an invalid word");
			return;
		}
		System.out.print("Enter the second word: ");
		String word2 = sc.nextLine();
		//validation for second word
		if (word2.trim().contains(" ")) {
			System.out.println(word2 + " is an invalid word");
			return;
		}

		//check if second word is reverse of first
		if (isReverse(word1, word2)) {
			//reverse the first word
			String reversedWord = reverseWord(word1);

			//convert reversed word to lowercase
			reversedWord = reversedWord.toLowerCase();

			//replace all vowels with '@'
			String finalWord = replaceVowels(reversedWord);

			//print the transformed word
			System.out.println(finalWord);

		} else {
			//if second word is not the reverse of first
			combineWords(word1, word2);
		}
	}

	//method to check if second word is reverse of first (case-insensitive)
	public static boolean isReverse(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		int i = 0;
		int j = word2.length() - 1;
		while (i < word1.length()) {
			if (word1.charAt(i) != word2.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	//method to reverse a word
	public static String reverseWord(String word1) {
		StringBuilder reversedWord = new StringBuilder();
		for (int i = word1.length() - 1; i >= 0; i--) {
			reversedWord.append(word1.charAt(i));
		}
		return reversedWord.toString();
	}
	//method to replace all vowels with '@'
	public static String replaceVowels(String word) {
		StringBuilder modifiedWord = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				modifiedWord.append('@');
			} else {
				modifiedWord.append(ch);
			}
		}
		return modifiedWord.toString();
	}

	//method to combine both words and process them
	public static void combineWords(String word1, String word2) {
		String combinedWord = (word1 + word2).toUpperCase();
		int vowels = 0;
		int consonants = 0;
		for (int i = 0; i < combinedWord.length(); i++) {
			char ch = combinedWord.charAt(i);
			if (isVowel(ch))
				vowels++;
			else
				consonants++;
		}

		//compare vowel and consonant counts
		if (vowels > consonants) {
			printFirstTwo(combinedWord, true);
		} else if (consonants > vowels) {
			printFirstTwo(combinedWord, false);
		} else {
			System.out.println("Vowels and consonants are equal");
		}
	}

	//method to check vowel
	public static boolean isVowel(char ch) {
		return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
	}

	//method to print first two unique vowels or consonants
	public static void printFirstTwo(String word, boolean requiredVowel) {
		char first = 0;
		int count = 0;

		for (int i = 0; i < word.length() && count < 2; i++) {
			char ch = word.charAt(i);

			if ((requiredVowel && isVowel(ch)) || (!requiredVowel && !isVowel(ch))) {
				if (count == 0) {
					System.out.print(ch);
					first = ch;
					count++;
				} else if (ch != first) {
					System.out.print(ch);
					count++;
				}
			}
		}
	}
}
