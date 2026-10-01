class EmergencyTask extends Thread {
    private String taskName;

    public EmergencyTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - " + taskName +
                " - Update " + i
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
        EmergencyTask patientMonitoring =
            new EmergencyTask("Patient Monitoring");

        EmergencyTask emergencyAlert =
            new EmergencyTask("Emergency Alert");

        EmergencyTask doctorNotification =
            new EmergencyTask("Doctor Notification");

        patientMonitoring.setName("Patient Monitoring Thread");
        emergencyAlert.setName("Emergency Alert Thread");
        doctorNotification.setName("Doctor Notification Thread");

        patientMonitoring.setPriority(Thread.MAX_PRIORITY);
        emergencyAlert.setPriority(Thread.NORM_PRIORITY);
        doctorNotification.setPriority(Thread.MIN_PRIORITY);

        patientMonitoring.start();
        emergencyAlert.start();
        doctorNotification.start();
    }
}