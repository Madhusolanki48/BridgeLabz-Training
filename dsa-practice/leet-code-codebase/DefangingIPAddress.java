package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 1108
//Replace every '.' in an IP address with '[.]'.

public class DefangingIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter IP address: ");
        String address = sc.nextLine();
        //method calling
        String result = defangIPaddr(address);
        //print output
        System.out.println("Defanged IP Address: " + result);
    }

    //method to defang IP address
    static String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                str.append("[.]");
            } else {
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }
}
