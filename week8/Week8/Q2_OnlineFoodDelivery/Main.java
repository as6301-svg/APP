class DeliveryTask extends Thread {
    private String activity;

    public DeliveryTask(String activity) {
        this.activity = activity;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - Priority: " +
                Thread.currentThread().getPriority() +
                " - " + activity +
                " - Task " + i
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

        DeliveryTask orderProcessing =
            new DeliveryTask("Processing Customer Orders");

        DeliveryTask deliveryTracking =
            new DeliveryTask("Tracking Delivery Location");

        DeliveryTask notification =
            new DeliveryTask("Sending Order Status Notification");

        orderProcessing.setName("OrderProcessing");
        deliveryTracking.setName("DeliveryTracking");
        notification.setName("Notification");

        orderProcessing.setPriority(Thread.MAX_PRIORITY);
        deliveryTracking.setPriority(Thread.NORM_PRIORITY);
        notification.setPriority(Thread.MIN_PRIORITY);

        orderProcessing.start();
        deliveryTracking.start();
        notification.start();
    }
}