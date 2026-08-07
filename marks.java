import java.util.Scanner;
class marks{
    float m1,m2,m3;
    void display(){
        float total=(m1+m2+m3);
        float avg=total/3;
        System.out.println("Total Marks= "+total);
        System.out.println("Average marks- "+avg);
    }
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       marks s=new marks();
       System.out.println("Enter marks of 3 subjects");
       s.m1=sc.nextFloat();
       s.m2=sc.nextFloat();
       s.m3=sc.nextFloat();
       s.display();
       sc.close();
    }
}
