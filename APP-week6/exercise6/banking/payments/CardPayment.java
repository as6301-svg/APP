package banking.payments;

/**
 * Payment method using card.
 */
public class CardPayment implements Payment, OnlineTransaction {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit/Debit Card.");
    }
}