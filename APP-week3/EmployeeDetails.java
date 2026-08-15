import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    double salary;

    // Constructor to initialize details
    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary : " + salary);
    }
}
public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner vc = new Scanner(System.in);

        System.out.print("Employee ID : ");
        int id = vc.nextInt();
        vc.nextLine(); // consume newline
        System.out.print("Employee Name : ");
        String name = vc.nextLine();
        System.out.print("Salary : ");
        double salary = vc.nextDouble();

        Employee emp = new Employee(id, name, salary);
        emp.displayDetails();

        vc.close();
    }
}