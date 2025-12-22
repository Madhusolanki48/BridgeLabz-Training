package strings;
import java.util.Scanner;
public class CountVowelsNConsonants {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string : ");
		String str=sc.nextLine();
		int[] result=countVowelsAndConsonants(str);
		//print output
		System.out.println("Count of vowels in the string is : "+result[0]);
		System.out.println("Count of consonants in the string is : "+result[1]);
		
	}
	//method to check vowels, consonants or not a letter
	public static String isVowelOrConsonant(char ch) {
			if(ch>=65 && ch<=90) {
				ch=(char)(ch+32);
			}
			if(!(ch>=97 && ch<=122)) {
				return new String("Not a letter");
			}
			else if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				return new String("Vowel");
			}
			else {
				return new String("Consonant");
			}
		
	}
	//method to count vowels and consonants
	public static int[] countVowelsAndConsonants(String str) {
		int[] result=new int[2];
		int vowel=0;
		int consonant=0;
		for(int i=0;i<str.length();i++) {
			if(isVowelOrConsonant(str.charAt(i)).equals("Vowel")) {
				vowel++;
			}
			else if(isVowelOrConsonant(str.charAt(i)).equals("Consonant")){
				consonant++;
			}
		}
		result[0]=vowel;
		result[1]=consonant;
	    return result;
	}

}
