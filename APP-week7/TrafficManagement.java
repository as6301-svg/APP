class TrafficJunction extends Thread {
    private String trafficStatus;
    private int intervalMs;

    public TrafficJunction(String trafficStatus, int intervalMs) {
        this.trafficStatus = trafficStatus;
        this.intervalMs = intervalMs;
    }

    @Override
    public void run() {
        try {
            for (int reportNum = 1; reportNum <= 3; reportNum++) {
                System.out.println("Thread Name: " + getName() + " | Traffic Status: " + trafficStatus + " | Report #" + reportNum);
                Thread.sleep(intervalMs);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) {
        System.out.println("=== Smart Traffic Management Monitoring Started ===\n");

        TrafficJunction junctionA = new TrafficJunction("Heavy Congestion (Slow Moving)", 400);
        junctionA.setName("North-Cross-Junction");

        TrafficJunction junctionB = new TrafficJunction("Moderate Traffic (Signal Balanced)", 650);
        junctionB.setName("Central-Square-Junction");

        TrafficJunction junctionC = new TrafficJunction("Clear Road (Smooth Flow)", 900);
        junctionC.setName("Highway-Exit-Junction");

        junctionA.start();
        junctionB.start();
        junctionC.start();

        try {
            junctionA.join();
            junctionB.join();
            junctionC.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== Traffic Monitoring Cycle Completed ===");
    }
}
