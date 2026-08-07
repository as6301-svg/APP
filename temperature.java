import java.util.Scanner;
class temperature {
    double celsius;
    void display() {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Celsius: " + celsius);
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        temperature temp = new temperature();
        System.out.println("Enter temperature in celsius");
        temp.celsius=sc.nextDouble();
        temp.display();
        sc.close();
    }
}