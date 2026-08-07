import java.util.*;

class Student {
    String name;
    int rollNumber;

    public void display() {
        System.out.println("The details of the student are: ");
        System.out.println("Name of the student is : " + name);
        System.out.println("The roll number of the student is : " + rollNumber);
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.println("Enter name of the student");
        s.name = sc.nextLine();

        System.out.println("Enter roll number of the student");
        s.rollNumber = sc.nextInt();

        s.display();
    }
}