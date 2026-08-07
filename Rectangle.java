import java.util.*;
class calculate{
    double length;
    double breadth;
    public void display_area(){
        double area = length * breadth;
        System.out.println("The details of the room are: ");
        System.out.println("Length of the room is : " + length);
        System.out.println("Breadth of the room is : " + breadth);
        System.out.println("The total floor area of the room is : " + area );

    }
}
public class Rectangle{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        calculate r = new calculate();
        System.out.println("Enter the length of the rectangle");
        r.length = sc.nextDouble();
        System.out.println("Enter the breadth of the rectangle");
        r.breadth = sc.nextDouble();
        r.display_area();
    }
}