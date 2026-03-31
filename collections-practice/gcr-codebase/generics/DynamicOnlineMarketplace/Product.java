package DynamicOnlineMarketplace;

//generic product class with bounded category
public class Product<T extends Category> {
	//attribute
    int productId;
    String productName;
    double price;
    String priceRange;
    T category;
    //constructor
    Product(int productId, String productName, double price, String priceRange, T category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.priceRange = priceRange;
        this.category = category;
    }

    public void displayProduct() {
        System.out.println("Product ID     : " + productId);
        System.out.println("Product Name   : " + productName);
        System.out.println("Price          : $" + price);
        System.out.println("Price Range    : " + priceRange);
        System.out.println("Category       : " + category.getCategoryName());
        System.out.println("-----------------------------------------");
    }
}
