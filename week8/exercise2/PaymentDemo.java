public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCardPayment(),
            new UPIPayment(),
            new NetBankingPayment()
        };
        double amount = 250.0;
        for (Payment p : payments) {
            p.pay(amount);
        }
    }
}