package lambda_expression;
import java.util.*;

class Product {
    String name;
    int price;
    int rating;
    //constructor
    Product(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}

public class CustomSortingECommerce {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Phone", 50000, 5),
                new Product("Laptop", 70000, 4),
                new Product("Tablet", 30000, 3)
        );

        //sort by price
        products.sort((a, b) -> a.price - b.price);

        products.forEach(p -> System.out.println(p.name + " " + p.price));
    }
}

