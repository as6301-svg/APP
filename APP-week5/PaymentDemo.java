abstract class Payment {
    abstract void makePayment();
}

class UPI extends Payment {
    @Override
    void makePayment() {
        System.out.println("Paid using UPI");
    }
}

class CreditCard extends Payment {
    @Override
    void makePayment() {
        System.out.println("Paid using Credit Card");
    }
}

class NetBanking extends Payment {
    @Override
    void makePayment() {
        System.out.println("Paid using Net Banking");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] methods = {new UPI(), new CreditCard(), new NetBanking()};
        for (Payment m : methods) {
            m.makePayment();
        }
    }
}