import java.util.Scanner;
public class AttendanceTracker {
    public static void main(String[] args) {
        Scanner vc = new Scanner(System.in);
        int days = 7;
        int[] attendance = new int[days];
        int presentCount = 0;
        for (int i = 0; i < days; i++) {
            System.out.print("Enter attendance for day " + (i + 1) + " (1-Present, 0-Absent): ");
            attendance[i] = vc.nextInt();
            if (attendance[i] == 1) {
                presentCount++;
            }
        }
        double percentage = ((double) presentCount / days) * 100;
        System.out.println("Total Present Days : " + presentCount);
        System.out.println("Attendance Percentage : " + percentage + "%");
        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }
        vc.close();
    }
}