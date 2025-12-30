package class_and_object;

// Class to store mobile phone details
class MobilePhone {
	//attributes
    private String brand;   
    private String model;
    private double price;

    //constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    //method to display phone details
    public void display() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }
}

public class MobilePhoneDetails {
    public static void main(String[] args) {
        MobilePhone mobile1 = new MobilePhone("VIVO", "VIVO V29", 15999);
        MobilePhone mobile2 = new MobilePhone("ONE PLUS", "ONE PLUS Nord4", 39999);
        MobilePhone mobile3 = new MobilePhone("APPLE", "iPhone Pro16", 79999);

        mobile1.display();
        mobile2.display();
        mobile3.display();
    }
}
