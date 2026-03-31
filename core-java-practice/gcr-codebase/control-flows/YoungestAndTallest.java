package control_flows;
import java.util.Scanner;
public class YoungestAndTallest {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input age of all three
        System.out.print("Enter the age of Amar : ");
        int amarAge = sc.nextInt();
        System.out.print("Enter the age of Akbar : ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter the age of Anthony : ");
        int anthonyAge = sc.nextInt();
        
        //input heights of all three
        System.out.print("Enter the height of Amar : ");
        int amarHeight = sc.nextInt();
        System.out.print("Enter the height of Akbar : ");
        int akbarHeight = sc.nextInt();
        System.out.print("Enter the height of Anthony : ");
        int anthonyHeight = sc.nextInt();

        // Youngest logic i.e smallest value among the three
        if (amarAge < akbarAge && amarAge < anthonyAge)
            System.out.println("Amar is the youngest");
        else if (akbarAge < amarAge && akbarAge < anthonyAge)
            System.out.println("Akbar is the youngest");
        else
            System.out.println("Anthony is the youngest");

        // Tallest logic i.e largest value among the three
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight)
            System.out.println("Amar is the tallest");
        else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight)
            System.out.println("Akbar is the tallest");
        else
            System.out.println("Anthony is the tallest");
    }
}
