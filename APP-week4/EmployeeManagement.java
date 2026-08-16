import java.util.Scanner;

class Employee {
    int empId;
    String name;
    double monthlySalary;

    Employee(int empId, String name, double monthlySalary) {
        this.empId = empId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    void display() {
        double annualSalary = monthlySalary * 12;
        double bonus = (monthlySalary >= 30000) ? annualSalary * 0.10 : 0;
        String eligible = (monthlySalary >= 30000) ? "Eligible" : "Not Eligible";

        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: Rs" + monthlySalary);
        System.out.println("Annual Salary: Rs" + annualSalary);
        System.out.println("Bonus: Rs" + bonus);
        System.out.println("Bonus Eligibility: " + eligible);
        System.out.println();
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Monthly Salary: ");
            double salary = sc.nextDouble();
            employees[i] = new Employee(id, name, salary);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }
    }
}
