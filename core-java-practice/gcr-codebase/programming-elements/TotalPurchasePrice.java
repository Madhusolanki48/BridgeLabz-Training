import java.util.Scanner;
public class TotalPurchasePrice {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the unit price of an item : ");
	        double unitPrice = sc.nextDouble(); // price per item
	        System.out.println("Enter the quantity of items : ");
	        int quantity = sc.nextInt();        // quantity
	        double total = unitPrice * quantity; // total cost
	        System.out.println("The total purchase price is INR " + total +" if the quantity is " + quantity +
	            " and unit price is INR " + unitPrice);
	 }

}
