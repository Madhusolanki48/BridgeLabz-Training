import java.util.Scanner;
public class UniversityDiscountNFee {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of fee : ");
        double fee = sc.nextDouble();            // student fee
        System.out.println("Enter the value of discount percent : ");
        double discountPercent = sc.nextDouble(); // discount percent
        double discount = (fee * discountPercent) / 100; // discount amount
        double finalFee = fee - discount;                // fee to pay
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f",
            discount, finalFee);
    }

}
