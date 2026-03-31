package scenario_based;
import java.util.*;
public class CafeCoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Which coffee do you want to order? (Espresso/Latte/Cappuccino or exit): ");
            String coffeeType = sc.next();
            if (coffeeType.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter the quantity of Coffee to be ordered : ");
            int quantityOfCoffee = sc.nextInt();
            int price = 0;
            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 198;
                    break;
                case "latte":
                    price = 159;
                    break;
                case "cappuccino":
                    price = 199;
                    break;
                default:
                    System.out.println("No such Coffee Type exists!");
                    continue;
            }

            int totalAmount = price * quantityOfCoffee;
            int gst = (totalAmount * 18) / 100;
            int billAmount = totalAmount + gst;

            System.out.println("Total Bill Amount = " + billAmount);
            System.out.println();
        }
    }
}
