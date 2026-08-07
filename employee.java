import java.util.Scanner;
class employee{
    String name;
    int salary;
    int empno;
    void display(){
        System.out.println("Name of employee ="+name);
        System.out.println("Salary of employee= "+salary);
        System.out.println("employee no. of employee= "+empno);
    }
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    employee s1=new employee();
    employee s2=new employee();
    System.out.println("Enter name of employee 1 ");
    s1.name=sc.nextLine();
    System.out.println("enter salary of employee 1");
    s1.salary=sc.nextInt();
     System.out.println("enter employee no. of employee 1");
     s1.empno=sc.nextInt();
     sc.nextLine();
    System.out.println("Enter name of employee 2");
    s2.name=sc.nextLine();
    System.out.println("Enter salary of employee 2");
    s2.salary=sc.nextInt();
    System.out.println("Enter employee no. of employee 2");
    s2.empno=sc.nextInt();
    s1.display();
    s2.display();
    sc.close();
}
}

