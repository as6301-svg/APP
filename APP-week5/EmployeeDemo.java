abstract class Employee {
    private String name;
    private int employeeId;
    private double basicSalary;

    public Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    public abstract double calculateSalary();
}

class Professor extends Employee {
    public Professor(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.2); // 20% bonus
    }
}

class LabAssistant extends Employee {
    public LabAssistant(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.1); // 10% bonus
    }
}

class AdministrativeStaff extends Employee {
    public AdministrativeStaff(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.15); // 15% bonus
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] employees = {
            new Professor("Prof. Kumar", 101, 120000),
            new LabAssistant("Lab Asst. Meena", 102, 35000),
            new AdministrativeStaff("Staff. Raj", 103, 45000)
        };
        for (Employee e : employees) {
            System.out.println(e.name + "'s Salary: " + e.calculateSalary());
        }
    }
}