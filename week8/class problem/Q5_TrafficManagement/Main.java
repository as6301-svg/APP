class TrafficMonitor extends Thread {
    private String trafficFunction;

    public TrafficMonitor(String trafficFunction) {
        this.trafficFunction = trafficFunction;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                getName() +
                " - " + trafficFunction +
                " - Traffic Status Report " + i
            );

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TrafficMonitor signalMonitoring =
            new TrafficMonitor("Signal Monitoring");

        TrafficMonitor congestionDetection =
            new TrafficMonitor("Congestion Detection");

        TrafficMonitor accidentMonitoring =
            new TrafficMonitor("Accident Monitoring");

        signalMonitoring.setName("Signal Monitoring Thread");
        congestionDetection.setName("Congestion Detection Thread");
        accidentMonitoring.setName("Accident Monitoring Thread");

        signalMonitoring.start();
        congestionDetection.start();
        accidentMonitoring.start();
    }
}