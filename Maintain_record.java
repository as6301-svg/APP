import java.util.*;
class StudentRecord {
    String name;
    int age;
    public void display() {
        System.out.println("The details of the student are: ");
        System.out.println("Name of the student is : " + name);
        System.out.println("Age of the student is : " + age);
        System.out.println();
    }
}
public class Maintain_record {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StudentRecord s1 = new StudentRecord();
        StudentRecord s2 = new StudentRecord();
        System.out.println("Enter details for Student 1:");
        System.out.println("Enter name of the student");
        s1.name = sc.nextLine();
        System.out.println("Enter age of the student");
        s1.age = sc.nextInt();
        sc.nextLine();
        System.out.println("\nEnter details for Student 2:");
        System.out.println("Enter name of the student");
        s2.name = sc.nextLine();
        System.out.println("Enter age of the student");
        s2.age = sc.nextInt();
        System.out.println();
        s1.display();
        s2.display();
    }
}