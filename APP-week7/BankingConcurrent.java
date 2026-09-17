class BankingTask implements Runnable {
    private String activityName;
    private int delayMs;

    public BankingTask(String activityName, int delayMs) {
        this.activityName = activityName;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        try {
            for (int count = 1; count <= 3; count++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " | Activity: " + activityName + " | Execution Count: " + count);
                Thread.sleep(delayMs);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BankingConcurrent {
    public static void main(String[] args) {
        System.out.println("=== Concurrent Banking Operations Started ===\n");

        Thread transactionThread = new Thread(new BankingTask("Transaction Processing", 500));
        transactionThread.setName("Transaction-Thread");

        Thread balanceThread = new Thread(new BankingTask("Balance Updating", 700));
        balanceThread.setName("Balance-Thread");

        Thread smsThread = new Thread(new BankingTask("SMS Notification", 900));
        smsThread.setName("SMS-Thread");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();

        try {
            transactionThread.join();
            balanceThread.join();
            smsThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== All Banking Operations Completed ===");
    }
}
