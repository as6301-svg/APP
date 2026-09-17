class ExamTask implements Runnable {
    private String activity;
    private int intervalMs;
    private int cycles;

    public ExamTask(String activity, int intervalMs, int cycles) {
        this.activity = activity;
        this.intervalMs = intervalMs;
        this.cycles = cycles;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= cycles; i++) {
                System.out.println("Thread [" + Thread.currentThread().getName() + "] is currently performing: " + activity + " | Round " + i);
                Thread.sleep(intervalMs);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        System.out.println("=== Online Examination System Started ===\n");

        Thread timerThread = new Thread(new ExamTask("Displaying Remaining Time", 600, 3));
        timerThread.setName("TimerThread");

        Thread autoSaveThread = new Thread(new ExamTask("Auto-Saving Student Answers", 900, 3));
        autoSaveThread.setName("AutoSaveThread");

        Thread networkThread = new Thread(new ExamTask("Checking Network Connection", 400, 3));
        networkThread.setName("NetworkCheckThread");

        timerThread.start();
        autoSaveThread.start();
        networkThread.start();

        try {
            timerThread.join();
            autoSaveThread.join();
            networkThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== All Exam Monitoring Activities Completed ===");
    }
}
