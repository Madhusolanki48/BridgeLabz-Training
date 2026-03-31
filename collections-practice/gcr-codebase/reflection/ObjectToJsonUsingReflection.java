package reflection;

import java.lang.reflect.Field;

//sample class (renamed)
class Product {
    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}

public class ObjectToJsonUsingReflection {

    //method to convert object to JSON-like string
    public static String toJson(Object obj) throws IllegalAccessException {

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder();
        json.append("{");

        for (int i = 0; i < fields.length; i++) {

            Field field = fields[i];
            field.setAccessible(true);

            json.append("\"").append(field.getName()).append("\": ");

            Object value = field.get(obj);

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {

        Product product = new Product(101, "Laptop", 75000.50);

        String json = toJson(product);
        System.out.println(json);
    }
}
