import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int marks1, marks2, marks3;
    double attendance;

    Student(int rollNumber, String name, int marks1, int marks2, int marks3, double attendance) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.attendance = attendance;
    }
}

public class StudentPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Marks in Subject 1: ");
            int m1 = sc.nextInt();
            System.out.print("Marks in Subject 2: ");
            int m2 = sc.nextInt();
            System.out.print("Marks in Subject 3: ");
            int m3 = sc.nextInt();
            System.out.print("Attendance percentage: ");
            double attendance = sc.nextDouble();
            students[i] = new Student(roll, name, m1, m2, m3, attendance);
        }

        int highestIndex = 0;
        double highestAverage = 0;

        for (int i = 0; i < 5; i++) {
            Student s = students[i];
            int totalMarks = 0;
            int[] marks = {s.marks1, s.marks2, s.marks3};
            for (int j = 0; j < 3; j++) {
                totalMarks += marks[j];
            }
            double average = totalMarks / 3.0;

            String result = (average >= 50) ? "Pass" : "Fail";
            String scholarship = (average >= 75 && s.attendance >= 80) ? "Eligible" : "Not Eligible";
            String performance = (average >= 85) ? "Excellent" : "Good";

            System.out.println();
            System.out.println("Roll Number: " + s.rollNumber);
            System.out.println("Name: " + s.name);
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average: " + average);
            System.out.println("Result: " + result);
            System.out.println("Scholarship: " + scholarship);
            System.out.println("Performance: " + performance);

            if (average > highestAverage) {
                highestAverage = average;
                highestIndex = i;
            }
        }

        Student top = students[highestIndex];
        System.out.println();
        System.out.println("Student with highest average: " + top.name + " (Roll No: " + top.rollNumber
                + ", Average: " + highestAverage + ")");
    }
}
