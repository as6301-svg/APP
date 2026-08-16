import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
}

public class ProductBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Product " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            products[i] = new Product(id, name, price, quantity);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            Product p = products[i];
            double totalPrice = p.price * p.quantity;
            double discount;
            if (totalPrice >= 5000) {
                discount = totalPrice * 0.10;
            } else {
                discount = totalPrice * 0.05;
            }
            double finalPrice = totalPrice - discount;

            System.out.println("Product ID: " + p.productId);
            System.out.println("Name: " + p.productName);
            System.out.println("Total Price: Rs" + totalPrice);
            System.out.println("Discount: Rs" + discount);
            System.out.println("Final Price: Rs" + finalPrice);
            System.out.println();
        }
    }
}
