package banking.payments;

public class UPIPayment implements SecurePayment, OnlineTransaction {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via UPI.");
    }

    @Override
    public void verifyPayment() {
        System.out.println("UPI payment verification successful.");
    }
}