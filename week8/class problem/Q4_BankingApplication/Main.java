class BankingTask implements Runnable {
    private String activity;

    public BankingTask(String activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - " + activity +
                " - Execution " + i
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread transaction =
            new Thread(new BankingTask("Transaction Processing"));

        Thread balance =
            new Thread(new BankingTask("Balance Updating"));

        Thread sms =
            new Thread(new BankingTask("SMS Notification"));

        transaction.setName("Transaction Thread");
        balance.setName("Balance Thread");
        sms.setName("SMS Thread");

        transaction.start();
        balance.start();
        sms.start();
    }
}