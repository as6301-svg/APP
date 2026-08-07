import java.util.Scanner;

public class StudentInfo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        String name;
        int regNo;
        int mark1, mark2, mark3;
        double average;
        System.out.print("Enter Student Name : ");
        name = sc.nextLine();
        System.out.print("Enter Register Number : ");
        regNo = sc.nextInt();
        System.out.print("Enter Mark 1 : ");
        mark1 = sc.nextInt();
        System.out.print("Enter Mark 2 : ");
        mark2 = sc.nextInt();
        System.out.print("Enter Mark 3 : ");
        mark3 = sc.nextInt();
        average = (mark1 + mark2 + mark3) / 3.0;
        System.out.println("\n------ STUDENT DETAILS ------");
        System.out.println("Student Name      : " + name);
        System.out.println("Register Number   : " + regNo);
        System.out.println("Average Marks     : " + average);
        sc.close();
    }
}