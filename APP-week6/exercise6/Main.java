import banking.accounts.*;
import banking.payments.*;

public class Main {
    public static void main(String[] args) {
        // Demonstrate polymorphism with Account hierarchy
        Account[] accounts = {
            new SavingsAccount("SA001", "Alice", 1000, 5.0),
            new CurrentAccount("CA001", "Bob", 500, 1000)
        };

        System.out.println("=== Account Details ===");
        for (Account acc : accounts) {
            acc.displayDetails();
            System.out.println();
        }

        // Demonstrate payment polymorphism
        Payment[] payments = {
            new UPIPayment(),
            new CardPayment()
        };

        System.out.println("=== Payment Transactions ===");
        for (Payment p : payments) {
            p.pay(250.0);
        }

        // Demonstrate SecurePayment's extra method
        System.out.println("=== Secure Payment Verification ===");
        Payment securePayment = new UPIPayment(); // Upipayment can be treated as SecurePayment
        // But we need to cast to SecurePayment to call verifyPayment
        if (securePayment instanceof SecurePayment) {
            ((SecurePayment) securePayment).verifyPayment();
        }

        // Demonstrate OnlineTransaction tagging using instanceof
        System.out.println("=== Online Transaction Check ===");
        for (Payment p : payments) {
            if (p instanceof OnlineTransaction) {
                System.out.println("Payment method is an online transaction.");
            } else {
                System.out.println("Payment method is not tagged as online transaction.");
            }
        }
    }
}