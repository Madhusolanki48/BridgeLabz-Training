package scenario_based;
import java.util.*;

public class CafeteriaMenuApp {

    static String[] menuItems = {"Cold Coffee", "Cheese Pizza", "Veg Sandwich", "Masala Dosa",
        "Paneer Roll", "French Fries", "Tea", "Pasta","Burger", "Chocolate Shake","Fried Momo"};

    //method to display menu
    public static void displayMenu() {
        System.out.println("\n---------------- Cafeteria Menu ----------------");
        for (int i = 1; i < menuItems.length; i++) {
            System.out.println(i + " : " + menuItems[i]);
        }
        System.out.println("-------------------------------------------------");
    }

    //method to get item by index
    public static String getItemByIndex(int index) {
        if (index < 0 || index >= menuItems.length)
            return "Invalid selection!";
        return menuItems[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.println("--------- Welcome to Campus Cafeteria  ---------");
        while (true) {
            displayMenu();
            System.out.print("Enter item index to order: ");
            int choice = sc.nextInt();
            String item = getItemByIndex(choice);
            System.out.println("You selected: " + item);
            System.out.println("--------------------------------------------");
            System.out.print("Would you like to order another item? (yes/no): ");
            sc.nextLine(); 
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                System.out.println("\nThank you for ordering! Enjoy your meal.");
                break;
            }
        }
    }
}
