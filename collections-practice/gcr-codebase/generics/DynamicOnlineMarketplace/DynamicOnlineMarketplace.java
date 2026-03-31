package DynamicOnlineMarketplace;
import java.util.*;

public class DynamicOnlineMarketplace {
    //generic method: apply discount dynamically
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price = product.price - (product.price * percentage / 100);
    }
    public static void main(String[] args) {
        System.out.println("-----  Welcome to Dynamic Online Marketplace  -----");
        System.out.println("---------------------------------------------------\n");

        List<Product<?>> catalog = new ArrayList<>(); // mixed product catalog

        Product<BookCategory> book =
                new Product<>(101, "Java Programming", 599, "$30 - $100", new BookCategory());

        Product<ClothingCategory> tshirt =
                new Product<>(102, "Oversized T-Shirt", 899, "$50 - $200", new ClothingCategory());

        Product<GadgetCategory> earbuds =
                new Product<>(103, "Wireless Earbuds", 2499, "$150 - $500", new GadgetCategory());

        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(earbuds);
        //method calling
        applyDiscount(book, 10);
        applyDiscount(tshirt, 15);
        applyDiscount(earbuds, 20);

        System.out.println("Product Catalog:\n");
        for (Product<?> product : catalog) product.displayProduct();

        System.out.println("\nAll products displayed successfully!");
    }
}
