abstract class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }

    public abstract double calculateDiscount();
}

class Electronics extends Product {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }
}

class Clothing extends Product {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }
}

class Book extends Product {
    public Book(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class ProductDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("E1", "Laptop", 1000),
            new Clothing("C1", "T-Shirt", 50),
            new Book("B1", "Java Guide", 30)
        };
        for (Product p : products) {
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() - discount;
            System.out.println(p.name + "'s Final Price: " + finalPrice);
        }
    }
}