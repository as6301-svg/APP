class ExaminationTask implements Runnable {
    private String taskName;

    public ExaminationTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(taskName);

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - " + taskName +
                " - " + i
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
        Thread displayTime =
            new Thread(new ExaminationTask("Display Remaining Time"));

        Thread autoSave =
            new Thread(new ExaminationTask("Auto-Save Answers"));

        Thread networkCheck =
            new Thread(new ExaminationTask("Check Network Connection"));

        displayTime.start();
        autoSave.start();
        networkCheck.start();
    }
}