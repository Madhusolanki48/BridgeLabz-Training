package extras;
import java.util.Scanner;
public class MostFrequentCharacter {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String : ");
		String str=sc.nextLine();
		//method call
		char result=isMostFrequentCharacter(str);
		//print output
		System.out.print("Most frequent character : "+result);
	}
	//method to find the most frequent character in a string.
	public static char isMostFrequentCharacter(String str) {
		int[] freq = new int[256];
        for (char ch : str.toCharArray())
            freq[ch]++;
        int max = 0;
        char ans = ' ';
        for (char ch : str.toCharArray())
            if (freq[ch] > max) { 
            	max = freq[ch]; ans = ch;
            	}
        return ans;
    }

}
